package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15651 {

    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        findNum( 0, N, M);

        System.out.print(sb);
    }

    static void findNum (int depth, int N, int M) {

        if ( depth == M) {
            for (Integer x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i =0; i<N; i++) {
            arr[depth] = i + 1;
            findNum(depth + 1, N, M);
        }
    }
}
