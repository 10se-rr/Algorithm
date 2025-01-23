package z_Atest.BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baek_16637_괄호추가하기
public class Baek_16637 {
    static char[] arr;
    static int max = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        arr = br.readLine().trim().toCharArray();

        dfs(0, arr[0] - '0');

        System.out.println(max);
    }

    static void dfs(int depth, int ans) {

        if (depth >= N-1) {
            max = Math.max(max, ans);
            return;
        }

        //1. 괄호 O,
        dfs(depth + 2, cal(ans, arr[depth + 1], arr[depth + 2] - '0'));
        //2. 괄호 x,
        if ( depth+4 < N) {
            int cal1 = cal(arr[depth + 2] - '0', arr[depth + 3], arr[depth + 4] - '0');
            dfs(depth + 4, cal(ans, arr[depth + 1], cal1));
        }
    }

    static int cal(int a, char b, int c) {

        if (b == '+') {
            return a + c;
        } else if (b == '-') {
            return a - c;
        } else
            return a * c;
    }
}
