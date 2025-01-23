package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_2091. 동전
public class Baek_2091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(st.nextToken()); // coffee가격
        int A = Integer.parseInt(st.nextToken()); // 1cents
        int B = Integer.parseInt(st.nextToken()); // 5cents
        int C = Integer.parseInt(st.nextToken()); // 10cents
        int D = Integer.parseInt(st.nextToken()); // 25cents
        out:
        for (int a = A; 0<=a; a--) {
            for (int b = B; 0<=b; b--) {
                for (int c = C; 0<=c; c--) {
                    for (int d = D; 0<=d; d--) {
                        if (a + b*5 + c*10 + d*25 == X) {
                            sb.append(a).append(' ').append(b).append(' ').append(c).append(' ').append(d);
                            break out;
                        }
                    }
                }
            }
        }
        if (sb.length() == 0) {
            sb.append('0').append(' ').append('0').append(' ').append('0').append(' ').append('0');
        }
        System.out.println(sb);
    }
}
