package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9663_re {

    static int N, count;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        count = 0;

        col = new boolean[N];      // 열 체크
        diag1 = new boolean[2 * N - 1];  // '/' 대각선 체크
        diag2 = new boolean[2 * N - 1];  // '\' 대각선 체크

        dfs(0);
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!col[j] && !diag1[row + j] && !diag2[row - j + N - 1]) {
                col[j] = diag1[row + j] = diag2[row - j + N - 1] = true;
                dfs(row + 1);
                col[j] = diag1[row + j] = diag2[row - j + N - 1] = false;
            }
        }
    }
}

