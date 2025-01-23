package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class BEAK2563 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[100][100];

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            for (int i = I; i < I + 10; i++) {
                for (int j = J; j < J + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum +=arr[i][j];
            }
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}