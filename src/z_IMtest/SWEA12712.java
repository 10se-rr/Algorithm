package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA12712 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int[] d1 = {1, 1, -1, -1};
            int[] d2 = {1, -1, -1, 1};
            for (int i = 0; i < N; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            int Max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = arr[i][j];
                    out:
                    for (int n = 0; n < 4; n++) {
                        for (int m = 1; m < M; m++) {
                            if (0 <= i + dr[n] * m && 0 <= j + dc[n] * m && i + dr[n] * m < N && j + dc[n] * m < N) {
                                sum += arr[i + dr[n] * m][j + dc[n] * m];
                            } else {
                                continue out;
                            }
                        }
                    }
                    Max = Math.max(Max, sum);
                    sum = arr[i][j];
                    out1:
                    for (int n = 0; n < 4; n++) {
                        for (int m = 1; m < M; m++) {
                            if (0 <= i + d1[n] * m && 0 <= j + d2[n] * m && i + d1[n] * m < N && j + d2[n] * m < N) {
                                sum += arr[i + d1[n]*m][j + d2[n]*m];
                            } else {
                                continue out1;
                            }
                        }
                    }
                    Max = Math.max(Max, sum);

                }
            }
            bw.write("#"+t+" "+Max+"\n");
        }
        bw.flush();
    }
}
