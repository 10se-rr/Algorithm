package BACKJOON.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int result = combination(N, R);
        System.out.println(result);
    }

    static int combination(int N, int R) {
        if (R == 0 || N == R) {
            return 1;
        }
        return combination(N - 1, R) + combination(N - 1, R - 1);
    }
}
