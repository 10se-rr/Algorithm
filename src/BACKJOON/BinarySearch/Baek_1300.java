package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Baek_1300.K번째 수
//
// 1 , min( 10^9, N*N ) 를 이분 탐색 하면서
// 아래에 있는 숫자가 총 몇개인지 살펴보고
// 범위를 줄여 나가자
// lowerBound를 쓸지 UppeeBound를 쓸지 고민했는데, lowerBound를 썼다.

public class Baek_1300 {
    static long N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        long front = 1;
        long rear = Math.min(1000000000L, N * N) + 1;

        while (front < rear) {

            long mid = (front + rear)/ 2;

            if (count(mid) < K) {
                front = mid + 1;
            } else {
                rear = mid;
            }
        }
        System.out.println(front);
    }

    static long count(long mid) {
        long cnt = 0;
        for (long i = 1; i <= N; i++) {

            if (mid / i >= N) {
                cnt += N;
            } else {
                cnt += mid / i;
            }
            if (cnt >= K) {
                return cnt;
            }
        }
        return cnt;
    }
}
