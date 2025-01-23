package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9251 {
    //LCS
    // 1. 시간으로 보면 DP 사용
    // 문제 풀이 방법
    // 1. 첫줄을 받고
    // 2. 두번쨰 줄을 받으면서 해당 글자가 있는지 확인
    // 3. 있으면 몇 번쨰 인덱스에 있는지 확인하고
    // 4. 해당 인덱스를 업데이트 이런식
    // 5. 작은 문제로 어떻게 쪼갤까?

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = ("x" + br.readLine().trim()).toCharArray();
        char[] arr2 = ("x" + br.readLine().trim()).toCharArray();
        int[][] dp = new int[arr1.length][arr2.length]; // 짧은 쪽 받으면 됨.// 0열은 현재 인덱스 1열은 현재 길이

        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[arr1.length-1][arr2.length-1]);
    }
}

