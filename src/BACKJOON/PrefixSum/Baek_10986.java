package BACKJOON.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Baek_10986.나머지 합

//연속된 구간의 합이 N으로 나누어 떨어지는 갯수
public class Baek_10986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        long[] remain = new long[M];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
            remain[(int) arr[i]]++;
        }

        long count = remain[0];

        for (int i = 0; i < M; i++) {
            count += (remain[i] * (remain[i] - 1)) / 2;
        }
        System.out.println(count);
    }
}
