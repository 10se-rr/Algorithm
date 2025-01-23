package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_2156.포도주 시식
public class Baek_2156re {
    static int[] score, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        score = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            score[i] = Integer.parseInt(br.readLine().trim());
        }
        System.out.println(func(N));
    }

    static int func(int N) {

        if (N >= 1) {
            dp[1] = score[1];
        }
        if (N >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i<N+1; i++ ) {
            dp[i] = Math.max(dp[i-3]+score[i-1]+score[i],Math.max(dp[i-2]+score[i],dp[i-1]));
        }
        return dp[N];

    }
}
