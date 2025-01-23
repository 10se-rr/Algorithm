package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_1932. 정수 삼각혐
public class Baek_1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[][] dp = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][i] += dp[i - 1][i - 1];
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1]+dp[i][j],dp[i-1][j]+dp[i][j]);
            }
        }

        int max = 0;

        for (int i = 0; i<N; i++) {
            max = max < dp[N-1][i] ? dp[N-1][i] : max;
        }
        System.out.println(max);
    }
}