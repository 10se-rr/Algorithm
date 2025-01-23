package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_2805.나무 자르기

// 가장 높은 인덱스를 찾고 싶다.
// 가장 높은 인덱스에서 들고가는 나무 길이가 같거나 큰 경우를 찾고 싶다.
// UpperBound를 찾으면 된다.
// int 범위는 21억4000만

public class Baek_2850 {
    static int N, M;
    static long total;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch(arr);

        System.out.print(result);

    }

    static int binarySearch(int[] arr) {

        int front = 0;
        int rear = 1000000001;

        while (front < rear) {

            int mid = (front + rear)/2;
            total = 0;
            total = sum(mid,arr);

            if (total < M) {
                rear = mid;
            }
            else if (M <= total) {
                front = mid + 1 ;
            }
        }
        return front - 1;
    }


    static long sum(int height,int[] arr) {

        for (int i = 0; i < N; i++) {

            if (height < arr[i]) {
                total += arr[i]-height;
            }
        }
        return total;
    }
}