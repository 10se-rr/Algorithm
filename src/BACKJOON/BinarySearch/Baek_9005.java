package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_9005. 1,2,3 더하기
public class Baek_9005 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(func(num)).append('\n');
        }
        System.out.println(sb);
    }

    static int func(int num) {

        if (dp[num] == 0) {
            for (int i = 1; i < num; i++) {
                dp[num] += func(i) + 1;
            }
        }
        return dp[num];
    }
}
