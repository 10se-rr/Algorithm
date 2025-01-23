package z_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToBinary_re {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N != 0) {

            sb.append(N%2);
            N /= 2;
        }
        sb.reverse();
        System.out.println(sb);

    }
}
