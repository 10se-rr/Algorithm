package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_2565.전깃줄 (1.DP) _ TopDown
// 1. LIS 이용
public class Baek_2565_TopDown {

    static int[] seq, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());

        seq = new int[501]; // 모든 요소들은 0으로 초기화 되어있음.

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            seq[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        dp = new int[501];

        for (int i = 1; i<501; i++) {
            if ( seq[i]!=0) {
                lis(i);
            }
        }


        int max = 1;
        for (int i = 1; i < 501; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(N - max);
    }

    static int lis(int N) {

        if (dp[N] == 0) {
            dp[N] = 1;
            for (int i=N-1; 0<i; i--) {

                if (seq[i] != 0 && seq[i]<seq[N]) {
                    dp[N] = Math.max(dp[N], lis(i)+1);
                }
            }
        }
        return dp[N];
    }
}


