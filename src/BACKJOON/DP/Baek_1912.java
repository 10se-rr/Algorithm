package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];
        ans[0] = arr[0];
        for (int i = 1; i < N; i++) {

            if (arr[i] < ans[i - 1] + arr[i]) {
                ans[i] = ans[i - 1] + arr[i];
            } else {
                ans[i] = arr[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
    }
}
