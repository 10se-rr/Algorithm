package z_IMtest;

import java.util.Scanner;

public class Q1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] snail = new int[N][N];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0, dir = 0;
            for (int i = 1; i <= N * N; i++) {
                snail[x][y] = i;
                int X = x + dx[dir];
                int Y = y + dy[dir];

                if (X < 0 || X >= N || Y < 0 || Y >= N || snail[X][Y] != 0) {
                    dir = (dir + 1) % 4;
                    X = x + dx[dir];
                    Y = y + dy[dir];
                }
                x = X;
                y = Y;
            }


            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
