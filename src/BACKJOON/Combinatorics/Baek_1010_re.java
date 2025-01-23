package BACKJOON.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1010_re {
    static int[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new int[M+1][M+1];
            sb.append(C(M, N)).append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static int C(int M, int N) {

        if (M ==N || N == 0) {
            return 1;
        }
        if (visited[M][N] !=0) {
            return visited[M][N];
        }
        return visited[M][N]=C( M-1,N) +C(M-1,N-1);
    }
}
