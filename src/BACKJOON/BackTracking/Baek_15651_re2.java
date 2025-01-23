package BACKJOON.BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15651_re2 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        findNum( 0);
        System.out.print(sb);
    }

    static void findNum (int depth) {

        if ( depth == M) {
            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i =0; i<N; i++) {
            arr[depth] = i + 1;
            findNum(depth + 1);
        }
    }
}