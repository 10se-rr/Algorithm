package BACKJOON.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_10830. 행렬제곱
//
// 계산을 어떤식으로 해야할까
// 나는 1000억을 2로 나누면 20번 안으로 계산이 나온다!!
// 반반으로 나눠서 계산하겠다.
public class Baek_10830 {
    static int[][] matrix;
    static int N;

    static int[][][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] result = pow(matrix, M);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static int[][] pow(int[][] matrix, long M) {

        if (M == 1) {
            return matrix;
        }

        if (M%2 == 0) {
            int[][] arr = pow(matrix, M/2);
            return multi(arr,arr);
        } else {
            int[][] arr = pow(matrix, M/2);
            return multi(multi(arr,arr),matrix);
        }
    }

    static int[][] multi(int[][] matrix1, int[][] matrix2) {

        int[][] ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = rowcol(matrix1, matrix2, i, j);
                ans[i][j] = num;
            }
        }
        return ans;
    }
    static int rowcol(int[][] matrix1,int[][] matrix2, int i, int j) {
        int sum = 0;
        for (int n=0; n<N; n++ ) {
            sum += matrix1[i][n]*matrix2[n][j];
        }
        return sum%1000;
    }
}

