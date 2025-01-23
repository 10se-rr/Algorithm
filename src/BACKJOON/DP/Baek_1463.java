package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baek_1463.1로 만들기

public class Baek_1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        System.out.println(one(N));

    }
    static int one(int N) {
        if (N==1)
            return 0;
        if (N==2)
            return 1;

        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[1] = 0;
        dp[2] = 1;

        for (int i=3; i<N+1; i++) {

            if (i%3==0) {
                dp[i] = dp[i] > dp[i/3] + 1 ? dp[i/3] +1 : dp[i];
            }
            if (i%2==0) {
                dp[i] = dp[i] > dp[i/2] + 1 ? dp[i/2] +1 : dp[i];
            }
            dp[i] = dp[i] > dp[i-1] + 1 ? dp[i-1] +1 : dp[i];
        }

        return dp[N];
    }
}
