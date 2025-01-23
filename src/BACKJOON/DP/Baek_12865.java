package BACKJOON.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_12865. 평범한 배낭
public class Baek_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        for (int i=0; i<N; i++) {
            int weight = weights[i];
            int value = values[i];
            for (int w = K; weight <= w; w-- ) {
                dp[w] = Math.max(dp[w],dp[w-weight]+ value);
            }
        }
        System.out.println(dp[K]);
    }
}
