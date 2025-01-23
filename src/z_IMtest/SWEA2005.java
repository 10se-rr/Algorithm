package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2005 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            System.out.println("#" + t);

            int N = Integer.parseInt(br.readLine());

            String str2 = "1";

            for (int n = 2; n < N + 1; n++) {
                StringBuilder sb = new StringBuilder();
                sb.append("1");
                for (int m = 1; m < n - 1; m++) {
                    sb.append((str2.charAt(m - 1) + str2.charAt(m) - '0' - '0'));
                }
                sb.append("1");

                for (int s = 0; s < n; s++) {
                    System.out.print(sb.charAt(s) + " ");
                }
                System.out.println();

                str2 = sb.toString();
            }
        }
    }
}
