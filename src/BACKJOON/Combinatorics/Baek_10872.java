package BACKJOON.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10872 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.print(factorial(N));
    }
    static int factorial(int N) {

        if (N<2) {
            return 1;
        } else {
            return N * factorial(N-1);
        }
    }
}
