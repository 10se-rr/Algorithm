package BACKJOON.DP;
// Baek_1149. RGB 거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
// N
// R G B
public class Baek_1149 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] dp = new int[N+1][3]; // 0열 R로 끝남 1열 G로 끝남 2열 B로 끝남

        StringTokenizer st;
        int paint[] = new int[3];
        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine().trim());
            paint[0] = Integer.parseInt(st.nextToken());
            paint[1] = Integer.parseInt(st.nextToken());
            paint[2] = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1]+paint[0],dp[i-1][2]+paint[0]);
            dp[i][1] = Math.min(dp[i-1][2]+paint[1],dp[i-1][0]+paint[1]);
            dp[i][2] = Math.min(dp[i-1][0]+paint[2],dp[i-1][1]+paint[2]);
        }

        int min = Integer.MAX_VALUE;

        for (int i=0; i<3; i++) {
            min = dp[N][i] < min ? dp[N][i] : min;
        }

        System.out.println(min);
    }
}
