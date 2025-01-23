package BACKJOON;

// Baek.2493 탑

// 스택에 넣고
// 현재 가지고 숫자 보다 스택 마지막에 있는 놈이 작으면
// 스택에 현재  해당 숫자를 넣는다
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2493 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }


        for (int i=0; i < n; i++) {
            int count = 1;
            int tmp = i;
            while ( i + count <= n && input[i] < input[i + count] ) {
                sb.append(tmp).append(' ');
                count++;
            }
            i += count - 1;
        }
        System.out.println(sb);
    }
}
