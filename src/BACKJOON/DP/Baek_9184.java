package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_9184. 신나는 함수 실행
public class Baek_9184 {

    static int dp[][][] = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (!(a == -1 && b == -1 && c ==-1)) {
            sb.append('w').append('(').append(a).append(',').append(' ').append(b).append(',').append(' ').append(c).append(')').append(' ').append('=').append(' ').append(w(a,b,c)).append('\n');
            st = new StringTokenizer(br.readLine().trim());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c) {

        if (dp[a + 50][b + 50][c + 50] == 0) {

            if (a <= 0 || b <= 0 || c <= 0)
                return dp[a + 50][b + 50][c + 50] = 1;
            else if (a > 20 || b > 20 || c > 20)
                return dp[a + 50][b + 50][c + 50] = w(20, 20, 20);
            else if (a < b && b < c)
                return dp[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            else
                return dp[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return dp[a + 50][b + 50][c + 50];
    }
}