package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution18 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            List<Integer> primeNum = new ArrayList<>();

            out:
            for (int N = A; N < B + 1; N++) {
                for (int n = 2; n <= Math.sqrt(N); n++) {
                    if (N % n == 0)
                        continue out;
                }
                primeNum.add(N);
            }


            int cnt = 0;
            for (Integer x : primeNum) {
                while (x != 0) {
                    if (x % 10==D) {
                        cnt++;
                        break;
                    }
                    x = x / 10;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}