package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baek_2579.계단 오르기
public class Baek_2579re {
    static int[] stair, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        stair = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine().trim());
        }
        System.out.println(func(N));
    }

    static int func(int N) {

        if (N == 1)
            return stair[1];
        if (N == 2)
            return stair[1] + stair[2];

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
        }
        return dp[N];
    }
}
