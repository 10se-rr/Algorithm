package MonthltyTest3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_2293. 동전 1
public class Baek_2293 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int c = 0; c < n; c++) {
            for (int i = 1; i < k + 1; i++) {
                if (coins[c] <= i) {
                    dp[i] += dp[i-coins[c]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
