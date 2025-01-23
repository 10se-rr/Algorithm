package BACKJOON.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_16139.인간-컴퓨터 상화작용
public class Baek_16139 {

    //문자열 S
    //특정 알파가 문자열S [l,r]에서 몇 번???
    //질문을 q 번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String S = br.readLine().trim();

        int[][] prefixSum = new int[S.length()+1][26]; // 행 = 갯수 //  열 = 철자

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (S.charAt(i-1) - 'a' == j) {
                    prefixSum[i][j] = prefixSum[i-1][j] + 1;
                } else {
                    prefixSum[i][j] = prefixSum[i-1][j];
                }
            }
        }


        int q = Integer.parseInt(br.readLine());

        for (int t = 0; t < q; t++) {
            st = new StringTokenizer(br.readLine());

            int key = st.nextToken().charAt(0)-'a';
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1 ;

            int result = prefixSum[r][key] - prefixSum[l-1][key];
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
