package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9461 {
    //나선에서 가장 긴 길이를 다음 길이로 정함.
    // P(N)은 가장 긴 길이의 삼각형
    static long[] p = new long[101];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        int T = Integer.parseInt(br.readLine().trim());

        for(int t = 1; t<=T; t++) {

            sb.append(P(Integer.parseInt(br.readLine().trim()))).append('\n');

        }
        System.out.println(sb);

    }

    static long P(int N) {

        if (N <=3) {
            return 1;
        }

        for (int i =3; i<=N; i++) {
            p[i] = p[i-2] + p[i-3];
        }
        return p[N];
    }
}
