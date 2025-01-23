package z_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSortTest {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new int[1000000];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i =0; i< 1000000; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, 1000000-1);

        System.out.println(arr[500000]);
    }
    static void quickSort(int left, int right) {
        if (left<right) {
            int pivot = arr[left];
            int L = left + 1;
            int R = right;

            while (L <= R) {

                while (L <= R && arr[L] <= pivot) L++;
                while (arr[R] > pivot) R--;
                if (L < R)
                    swap(L, R);
            }
            swap(left, R);
            quickSort(left, R - 1);
            quickSort(R + 1, right);
        }
    }
    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
