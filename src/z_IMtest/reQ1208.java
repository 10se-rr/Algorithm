package z_IMtest;

import java.util.Scanner;

public class reQ1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {
            int dump = sc.nextInt();

            int[] count = new int[101];
            for (int i = 0; i < 100; i++)
                count[sc.nextInt()]++;

            while (dump > 0) {
                int max = 100;
                while (max > 0 && count[max] == 0) {
                    max--;
                }
                int min = 0;
                while (min < 100 && count[min] == 0) {
                    min++;
                }
                if (max - min <= 1)
                    break;

                count[max]--;
                count[min]--;
                count[max - 1]++;
                count[min + 1]++;

                dump--;
            }

            int max = 100;
            while (max > 0 && count[max] == 0) {
                max--;
            }

            int min = 0;
            while (min < 100 && count[min] == 0) {
                min++;
            }
            System.out.println("#" + T + " " + (max-min));
        }
    }
}