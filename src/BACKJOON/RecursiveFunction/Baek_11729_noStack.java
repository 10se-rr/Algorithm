package BACKJOON.RecursiveFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Baek_11729 하노이탑

public class Baek_11729_noStack {
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int min = getMin(N);
        System.out.println(min);
        func (N,1,3);
        System.out.println(sb);
    }
    static void func(int N,int a, int b) { // N개를 a에서 b로 옮기는 함수 a,b = 0,1,2
        if (N == 1) {
            move(a,b);
        } else {                                // 0 2
            func(N - 1, a, 6-(a+b));   // 0 1 (N -1) 개를 옮김
            func(1 ,a , b);               // 0 2 1개를 옮김
            func(N - 1, 6-(a+b), b);   // 1 2 개
        }
    }

    static void move(int A, int B) {

        sb.append(A).append(' ').append(B).append('\n');
    }

    static int getMin(int N) {
        if (N==1) {
            return 1;
        }

        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i=3; i<=N; i++) {
            dp[i] = 2*dp[i-1] + 1;
        }
        return dp[N];
    }
}
