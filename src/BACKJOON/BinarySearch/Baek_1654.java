package BACKJOON.BinarySearch;
//Baek_1654.랜선 자르기

// K개 가지고 있고, N개로 만들 것
// N개 이상은 N개라고 쳐줌
// 1<=K<=10000, 1<=N<=1000000, K<=N
// int 로 받으면 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1654 {
    static int K, N;
    static long max;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        max = 0;
        binarySearch(0, arr[0], arr);
        System.out.println(max);
    }

    static void binarySearch(long front, long rear, int[] arr) {

        long mid = (front + rear) / 2;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i] / mid;
        }

        if (front <= rear) {
            if (sum == N) {
                max = Math.max(max, mid);
                binarySearch(front, mid - 1, arr);
            }
            if (max == N) return;

            if (sum < N) {
                binarySearch(front, mid - 1, arr);
            } else {
                binarySearch(mid + 1, rear, arr);
            }
        }
    }
}