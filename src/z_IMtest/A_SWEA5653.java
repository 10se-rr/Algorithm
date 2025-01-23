package z_IMtest;

import java.io.*;
import java.util.*;

public class A_SWEA5653 {


    static class Cell implements Comparable<Cell> {
        int x, y, life, time, state; // state: 0 - inactive, 1 - active, 2 - dead

        Cell(int x, int y, int life, int time, int state) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Cell o) {
            return o.life - this.life;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            String[] nmk = br.readLine().trim().split(" ");
            int N = Integer.parseInt(nmk[0]);
            int M = Integer.parseInt(nmk[1]);
            int K = Integer.parseInt(nmk[2]);

            int[][] grid = new int[N + K * 2][M + K * 2];
            PriorityQueue<Cell> pq = new PriorityQueue<>();
            List<Cell> activeCells = new ArrayList<>();

            for (int i = K; i < K + N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = K; j < K + M; j++) {
                    int lifeSpan = Integer.parseInt(line[j - K]);
                    if (lifeSpan > 0) {
                        grid[i][j] = lifeSpan;
                        pq.add(new Cell(i, j, lifeSpan, lifeSpan, 0)); // Inactive cells
                    }
                }
            }

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int time = 1; time <= K; time++) {
                while (!pq.isEmpty() && pq.peek().time == time) {
                    Cell cell = pq.poll();
                    if (cell.state == 0) { // Becomes active
                        cell.state = 1;
                        cell.time += cell.life;
                        activeCells.add(cell);
                    }
                }

                List<Cell> newCells = new ArrayList<>();
                for (Cell cell : activeCells) {
                    if (cell.state == 1 && cell.time == time) { // Spread and becomes dead
                        cell.state = 2;
                        for (int d = 0; d < 4; d++) {
                            int nx = cell.x + dx[d];
                            int ny = cell.y + dy[d];
                            if (grid[nx][ny] == 0) {
                                grid[nx][ny] = cell.life;
                                newCells.add(new Cell(nx, ny, cell.life, time + cell.life + 1, 0));
                            }
                        }
                    }
                }

                pq.addAll(newCells);
            }

            int result = 0;
            for (Cell cell : pq) {
                if (cell.state != 2) {
                    result++;
                }
            }
            for (Cell cell : activeCells) {
                if (cell.state != 2) {
                    result++;
                }
            }

            bw.write("#" + t + " " + result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
