package BACKJOON.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_11047. 동전 0
public class Baek_11047 {
    // 하위 동전이 상위 동전의 약수 이므로 그리디로 풀겠음
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = N - 1; 0 <= i; i--) {
            count += K / coins[i];
            K %= coins[i];
        }
        System.out.println(count);
    }
}

