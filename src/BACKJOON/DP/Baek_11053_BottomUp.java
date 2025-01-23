package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_11053.가장 긴 증가하는 부분 수열 (Longest Increasing Sequence)
// 1. BottomUP 방식 (반복분)
public class Baek_11053_BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for (int i=0; i<N; i++) {

            dp[i] = 1; // 가장 처음 1로 초기화

            for (int j= 0; j< i; j++) {

                if (seq[j] < seq[i] && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i<N; i++) {
            max = max < dp[i] ? dp[i] : max;
        }
        System.out.println(max);
    }
}
