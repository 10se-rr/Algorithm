package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            int v = 0;
            int distance = 0;
            int N = Integer.parseInt(br.readLine());
            for (int n = 0; n < N; n++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int status = Integer.parseInt(st.nextToken());
                if (status == 1) {
                    v += Integer.parseInt(st.nextToken());
                    distance += v;

                } else if (status == 2) {
                    int acc = Integer.parseInt(st.nextToken());
                    if (acc <= v) {
                        v -= acc;
                        distance += v;
                    } else v = 0;

                } else {
                    distance += v;
                }
            }
            bw.write("#" + t + " " + distance+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

