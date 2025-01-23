package z_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mergeSortTest {
    static int[] sortedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1000000];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i =0; i< 1000000; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,0, 1000000-1);

        System.out.println(arr[500000]);
    }
    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) { // left == right 가 동일 증 길이가 1이 될떄 까지 계속 자름.
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    static void merge(int[] arr, int left, int mid, int right) {

        int L = left; // 왼쪽 집합
        int R = mid+1; // 오른쪽 집합
        int idx = left; // 이 지점 부터 채워 넣어야함.

        while (L <=mid && R <= right) {

            if (arr[L] <= arr[R])
                sortedArr[idx++] = arr[L++];
            else
                sortedArr[idx++] = arr[R++];
        }
        // 어느 순간 L이 mid 를 넘어서거나, R이 right를 넘어섰다.
        if (L <= mid) {
            for (int i = L; i<=mid; i++) {
                sortedArr[idx++] = arr[i];
            }
        } else {
            for (int j = R; j<=right; j++) {
                sortedArr[idx++] = arr[j];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = sortedArr[i];
        }
    }
}
