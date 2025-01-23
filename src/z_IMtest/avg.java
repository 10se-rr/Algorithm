package z_IMtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class avg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();


        for (int t = 1; t < T + 1; t++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                arr.add(sc.nextInt());
            }

            Collections.sort(arr);
            arr.remove(9);
            arr.remove(0);

            double sum = 0;
            for (Integer x : arr) {
                sum += x;
            }
            double avg = sum / arr.size();

            System.out.printf("#%d %.0f%n", t, avg);


        }
    }
}
