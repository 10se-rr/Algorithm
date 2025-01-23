package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_10816. 숫자 카드2(카운팅배열)
public class Baek_10816_Counting {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int[] count = new int[20000001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                count[count.length + num]++;
            } else {
                count[num]++;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                sb.append(count[count.length + num]).append(' ');
            } else {
                sb.append(count[num]).append(' ');
            }
        }
        System.out.println(sb);
    }
}
