package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Baek_2178_미로탐색
public class Baek_2178 {
    static char[][] maze;
    static int count = 0;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = (br.readLine().trim()).toCharArray();
        }

        bfs(0); // (1, 1) -> (0, 0)


    }

    static void bfs(int num) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};


        Queue<Integer> Q = new LinkedList<>();
        Q.add(num);

        while (!Q.isEmpty()) {
            int curr = Q.poll();
            int row = curr / M;
            int col = curr % M;
            visited[row][col] = true;
            for (int d = 0; d < 4; d++) {
                int R = row + dr[d];
                int C = col + dc[d];
                if (!visited[R][C] && maze[R][C] == '1') {
                    Q.add((R) * M + C);
                }
            }
        }
    }
}
