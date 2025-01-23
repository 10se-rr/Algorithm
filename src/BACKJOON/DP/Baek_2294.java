package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Baek_2294.동전2
public class Baek_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int n = 0; n < N; n++) {
            coins[n] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[K + 1];

        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] =0;

        for(int i=0; i<N; i++) {
            for (int j = coins[i]; j<=K; j++) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }

        if (dp[K] != Integer.MAX_VALUE-1) {
            System.out.println(dp[K]);
        } else {
            System.out.println(-1);
        }

    }
}
