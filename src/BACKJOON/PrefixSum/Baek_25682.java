package BACKJOON.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_25682. 체스판 다시 칠하기2
public class Baek_25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        boolean flag = true;

        for (int i = 1; i < N + 1; i++) {
            if (i % 2 != 0)
                flag = true;
            else
                flag = false;

            char[] input = br.readLine().trim().toCharArray();

            for (int j = 1; j < M + 1; j++) {
                if (flag) {
                    if (input[j - 1] == 'B')
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + 1;
                    else
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                    flag = false;
                } else {
                    if (input[j - 1] == 'W')
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + 1;
                    else
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                    flag = true;
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = K; i < N + 1; i++) {
            for (int j = K; j < M + 1; j++) {
                int tmp = arr[i][j] - arr[i - K][j] - arr[i][j - K] + arr[i - K][j - K];
                if (2 * tmp < K*K)
                    min = Math.min(min, tmp);
                else
                    min = Math.min(min, K*K - tmp);
            }
        }
        System.out.println(min);
    }
}
