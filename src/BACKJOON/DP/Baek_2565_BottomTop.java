package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_2565.전깃줄 (1.DP)
// 1. LIS 이용
public class Baek_2565_BottomTop {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());

        int[] seq = new int[501]; // 모든 요소들은 0으로 초기화 되어있음.

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            seq[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[501];

        for (int i=1; i<501; i++) {
            if (seq[i] != 0) {
                dp[i] = 1;

                for (int j=1; j<i; j++) {

                    if (seq[j] !=0 && seq[j] < seq[i]) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
        }
        int max = 1;
        for (int i= 1; i<501; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(N-max);
    }
}


