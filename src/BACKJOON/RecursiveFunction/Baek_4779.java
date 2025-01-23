package BACKJOON.RecursiveFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_4779 {
    static char[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        while (input != null) {

            int N = Integer.parseInt(input);

            arr = new char[pow(N)];

            for (int i=0; i < arr.length; i++) {
                arr[i] = '-';
            }
            sort(0, arr.length);
            sb.append(arr).append('\n');
            input = br.readLine();
        }
        System.out.println(sb);
    }

    static void sort(int left, int right) {

        if (left + 1 < right) {
            int m1 = (2 * left + right) / 3;
            int m2 = (left + 2 * right) / 3;

            delete(m1, m2);

            sort(left, m1);
            sort(m2, right);
        }
    }

    static void delete(int left, int right) {

        for (int i = left; i < right; i++) {
            arr[i] = ' ';
        }
    }

    static int pow(int N) {
        if (N ==0 )
            return 1;
        if (N == 1)
            return 3;
        return 3 * pow(N - 1);
    }
}
