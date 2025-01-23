package z_IMtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class rereQ1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = 1; T <= 10; T++) {
            int dump = Integer.parseInt(br.readLine().trim());

            int[] count = new int[101];
            String[] inputs = br.readLine().trim().split("\\s+");
            for (int i = 0; i < 100; i++) {
                count[Integer.parseInt(inputs[i])]++;
            }

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
            bw.write("#" + T + " " + (max - min) + "\n");
        }
        bw.flush();
        bw.close();
    }
}