package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1959 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st1.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st2.nextToken());
            }
            int Max = 0;
            if (N <= M) {
                for (int i = 0; i <= M - N; i++) {
                    int sum =0;
                    for (int j = 0; j < N; j++) {
                        sum += A[j] * B[i + j];
                    }
                    Max = Math.max(Max, sum);
                }
            } else {
                for (int j = 0; j <= N - M; j++) {
                    int sum =0;
                    for (int i = 0; i < M; i++) {
                        sum += B[i] * A[j + i];
                    }
                    Max = Math.max(Max, sum);
                }
            }
            bw.write("#" + t + " " + Max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}