package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1904 {
    // Baek_1904. 01 타일
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        System.out.print(dp(N));

    }

    static int dp(int N) {

        if ( N==1 || N==2) return N;

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<N+1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%15746; // 각 단계에서 나눠주지 않았더니, 오버플로우가 났음.
        }                                          // 어차피 필요한 값은 나머지이기에, 나머지 값을 계속 업데이트 함.
        return dp[N];                              // 갑자기 음수가 출력 된다면, 정수 오버 플로우 기억하자...
    }
}