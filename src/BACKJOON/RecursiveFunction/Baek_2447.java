package BACKJOON.RecursiveFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_2447_별찍기
public class Baek_2447 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = '*';
            }
        }

        func(N, 1);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void func(int N, int depth) {

        if (N == 1) return;

        int M = N / 3;
        for (int n = 0; n < depth; n++) {
            for (int m = 0; m < depth; m++) {
                for (int i = N * n + M; i < N * n + M * 2; i++) {
                    for (int j = N * m + M; j < N * m + M * 2; j++) {
                        arr[i][j] = ' ';
                    }
                }
            }
        }
        func(N / 3, depth * 3);
    }
}
