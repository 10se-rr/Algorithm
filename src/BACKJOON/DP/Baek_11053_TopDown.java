package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_11053.가장 긴 증가하는 부분 수열 (Longest Increasing Sequence)
// 1. TopDown 방식 (재귀)
public class Baek_11053_TopDown {
    static int[] seq,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];

        for (int i=0;i<N; i++) {
            lis(i);
        }

        int max = 0;

        for (int i=0; i<N; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);

    }
    static int lis(int N) {

        if (dp[N] == 0) {
            dp[N] = 1;

            for (int i= N-1; 0<=i; i--) {
                if (seq[i] < seq[N]) {
                    dp[N] = Math.max(dp[N], lis(i) +1);
                }
            }
        }
        return dp[N];
    }
}
