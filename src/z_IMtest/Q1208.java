package z_IMtest;

import java.util.Arrays;
import java.util.Scanner;

public class Q1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {

            int dump = sc.nextInt();

            int[] site = new int[100];

            for (int i = 0; i < 100; i++) {
                site[i] = sc.nextInt();
            }

            for (int i = 0; i < dump; i++) {
                Arrays.sort(site);
                int diff = site[99] - site[0];
                if (diff <= 1)
                    break;
                else {
                    site[99]--;
                    site[0]++;
                }
            }
            Arrays.sort(site);
            int finalDiff = site[99] - site[0];
            System.out.println("#"+T+" "+finalDiff);
        }
    }
}