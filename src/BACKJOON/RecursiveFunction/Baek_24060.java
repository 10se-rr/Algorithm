package BACKJOON.RecursiveFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_24060 {
    static int[] sortedArr;
    static int[] arr;
    static int count = 0;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        arr = new int[N];
        sortedArr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N - 1);
        System.out.println(-1);
    }

    static void mergeSort(int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {

        int L = left;
        int R = mid + 1;
        int idx = left;

        while (L <= mid && R <= right) {

            if (arr[L] <= arr[R])
                sortedArr[idx++] = arr[L++];
            else
                sortedArr[idx++] = arr[R++];
        }

        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                sortedArr[idx++] = arr[i];
            }
        } else {
            for (int i = R; i <= right; i++) {
                sortedArr[idx++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sortedArr[i];
            count += 1;
            if (count == K) {
                System.out.println(arr[i]);
                System.exit(0);
            }
        }
    }
}
