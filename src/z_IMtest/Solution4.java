package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + t);
            int[][] rotated90 = rotate90(arr, N);
            int[][] rotated180 = rotate90(rotated90, N);
            int[][] rotated270 = rotate90(rotated180, N);

            for (int i = 0; i < N; i++) {
                printRow(rotated90[i]);
                printRow(rotated180[i]);
                printRow(rotated270[i]);
                System.out.println();
            }
        }
    }

    private static int[][] rotate90(int[][] arr, int N) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    private static void printRow(int[] row) {
        for (int value : row) {
            System.out.print(value);
        }
        System.out.print(" ");
    }
}
