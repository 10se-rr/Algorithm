package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1006 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, W, min;
    static int[][] site;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken()); // 한 줄 당 수
            W = Integer.parseInt(st.nextToken()); // 특수 소대당 소대원 수

            site = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    site[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[2][N];
            min = Integer.MAX_VALUE;

            dfs(0, 0);
            visited = new boolean[2][N];
            dfs(1,0);

            sb.append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static void dfs(int idx, int count) {

        if (idx == 2 * N) {
            min = Math.min(min, count);
            return;
        }

        int r = idx / N;
        int c = idx % N;

        if (visited[r][c]) {
            dfs(idx + 1, count);
            return;
        }

        // 1. 현재 위치만 방문
        visited[r][c] = true;
        dfs(idx + 1, count + 1);
        visited[r][c] = false;

        // 2. 수평으로 오른쪽 칸과 같이 방문
        if (!visited[r][(c + 1)%N] && site[r][c] + site[r][(c + 1)%N] <= W) {
            visited[r][c] = true;
            visited[r][(c + 1)%N] = true;
            dfs(idx + 2, count + 1);
            visited[r][c] = false;
            visited[r][(c + 1)%N] = false;
        }

        // 3. 수직으로 아래쪽 칸과 같이 방문
        if (r == 0 && !visited[1][c] && site[0][c] + site[1][c] <= W) {
            visited[0][c] = true;
            visited[1][c] = true;
            dfs(idx + 1, count + 1);
            visited[0][c] = false;
            visited[1][c] = false;
        }
    }
}
