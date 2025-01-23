package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_10844.쉬운 계단 수
public class Baek_10844 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % 1000000000 + dp[i - 1][j + 1] % 1000000000) % 1000000000;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += dp[N][i];

            sum %= 1000000000;
        }
        System.out.print(sum % 1000000000);
    }
}


