package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_2156.포도주시식
//@@
// 1. 연속으로 놓여 있는 3잔 마실 수 없다.
// 2. 최대한 많은 양의 포도주를 맛보고 싶다.
public class Baek_2156 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] dp = new int[N + 1];

        if (N >= 3) {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            for (int i = 3; i < N + 1; i++) {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            }
            System.out.println(dp[N]);
        } else if (N == 1) {
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[1]+arr[2]);
        }
    }
}
