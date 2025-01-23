package z_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToBinary {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Binary = 0;
        int M = 0;
        while (N !=0) {
            Binary += power(10, M++) * (N%2);
            N /=2;
        }
        System.out.println(Binary);
    }
    static int power( int N, int M) {

        if (M == 0) {
            return 1;
        }
        if (M%2 ==0) return power(N, M/2)* power(N, M/2);

        else return power(N, M/2)* power(N, M/2) * N;
    }
}
