package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_24416.알고리즘 수업 - 피보나치 수1
public class Baek_24416 {
    static int count1 = 1;
    //static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        fib(N);
        //fibonacci(N);

        System.out.println(count1 +" "+(N-2));
    }

    // 1. 재귀
    static int fib(int N) {
        if (N ==1 || N==2) {
            return 1;
        }
        else {
            count1 +=1;
            return fib(N-2) + fib(N-1);
        }
    }

    // 2. DP
    /*static int fibonacci(int N) {

        if (N ==1 || N ==2) {
            return 1;
        }
        int[] dp = new int[N+1];

        for (int i =3; i<N+1; i++) {
            count2 +=1;
            dp[i] = dp[i-2] +dp[i-2];
        }
        return dp[N];
    }*/
}
