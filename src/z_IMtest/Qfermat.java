package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Qfermat {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int remain = combination_mod(p,q);
            System.out.println("#" +t+" "+ remain);
        }
    }
    public static int combination_mod(int p, int q) {
        if (q > p)
            return 0;
        if (q == 0 || q == p)
            return 1;

        long[] fac = new long[p + 1];
        fac[0] =1;
        for (int i = 1; i <=p; i++) {
            fac[i] = (fac[i-1]*i) % 1234567891;
        }
        // fac[q] , 1234567891   //  fac[p-q], 123456789

        return (int) (fac[p]*(power(fac[q],1234567889)%1234567891)*(power(fac[p-q],1234567889)%1234567891));

    }



    public static long power(long x, long y) {
        long result = 1;
        x = x % 1234567891;

        while (y > 0) {
            if (y % 2 != 0) {
                result = (result * x) % 1234567891;
            }
            y = y / 2;
            x = (x * x) % 1234567891;
        }
        return result;
    }
}
