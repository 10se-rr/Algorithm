package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baek_2579.계단 오르기
public class Baek_2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine().trim());
        }
        if (N >= 3) {
            dp[1] = stair[1];
            dp[2] = stair[1] + stair[2];

            for (int i = 3; i < N + 1; i++) {
                dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
            }
            System.out.println(dp[N]);
        } else if (N==1) {
            System.out.println(stair[1]);
        } else {
            System.out.println(stair[1] + stair[2]);
        }
    }
}