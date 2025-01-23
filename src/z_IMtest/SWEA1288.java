package z_IMtest;

import java.io.*;

public class SWEA1288 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {

            int N = Integer.parseInt(br.readLine());

            boolean[] arr = new boolean[10];

            int num = 1;
            out:
            while (true) {
                int tmp = num * N;
                while (tmp != 0) {
                    arr[tmp % 10] = true;
                    tmp = tmp / 10;
                }
                num++;
                for (int i = 0; i<10; i++) {
                    if (!arr[i])
                        continue out;
                }
                break;
            }
            bw.write("#" + t + " " + N*(num - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}