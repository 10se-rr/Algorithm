package BACKJOON.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_2559_수열
public class Baek_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[N];
        int[] sum = new int[N];
        for (int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[K-1] += arr[i];
        }
        int max = sum[K-1];
        for (int i=K; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] - arr[i - K] + arr[i];
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
