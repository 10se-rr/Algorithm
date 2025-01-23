package BACKJOON.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1010 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(C(M, N)).append('\n');
        }
        System.out.print(sb);
    }

    static int C(int n, int k) {
        int[][] c = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            c[i][0] = 1;
            c[i][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return c[n][k];
    }
}