package MonthltyTest3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_cheese {
    static int N, max, available;
    static int[][] cheese;
    static boolean[][] visited, tmp;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N][N];
            tmp = new boolean[N][N];
            max = 1;
            int day = 1;
            available = N * N;

            while (available > 0) {
                eat(day++);
                int count = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!tmp[i][j]) {

                            dfs(i, j);
                            count++;
                        }

                    }
                }
                max = Math.max(max, count);
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

    static void eat(int day) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] == day) {
                    visited[i][j] = true;
                }
                tmp[i][j] = visited[i][j];
            }
        }
    }

    static void dfs(int row, int col) {

        if (!tmp[row][col]) {
            tmp[row][col] = true;

            for (int d = 0; d < 4; d++) {
                int nextR = row + dr[d];
                int nextC = col + dc[d];
                if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N && !tmp[nextR][nextC]) {
                    dfs(nextR, nextC);
                }
            }
        }
    }
}
