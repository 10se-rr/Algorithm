package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9663 {

    static int[][] board;
    static boolean[] visited;
    static int N, count;
    static int[] dr = {1, 1};
    static int[] dc = {1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        count = 0;
        board = new int[N][N];
        visited = new boolean[N];
        dfs(0);

        System.out.println(count);
    }

    static void dfs(int I) {

        if (I == N) {
            count++;
            return;
        }

        for (int j = 0 ; j< N; j++) {
            int r;
            int c;
            if(!visited[j] && board[I][j] == 0) {
                visited[j] = true;
                for (int idx = 0; idx < 2; idx++) {
                    for (int start = 1; start < N -I; start++) {
                        r = I + start * dr[idx];
                        c = j + start * dc[idx];

                        if (r < N && 0 <= c && c < N) {
                            board[r][c] += 1;
                        } else break;
                    }
                }
                dfs( I+1);

                for (int idx = 0; idx < 2; idx++) {
                    for (int start = 1; start < N - I; start++) {
                        r = I + start * dr[idx];
                        c = j + start * dc[idx];

                        if (r < N && 0 <= c && c < N) {
                            board[r][c] -= 1;
                        } else break;
                    }
                }
                visited[j] = false;
            }
        }
    }
}