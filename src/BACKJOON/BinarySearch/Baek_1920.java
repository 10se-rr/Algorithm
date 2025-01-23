package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Baek_1920. 수 찾기
public class Baek_1920 {
    static int search;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int t = 0; t < M; t++) {
            search = Integer.parseInt(st.nextToken());
            binarySearch(0, N-1);
        }
        System.out.print(sb);
    }

    static void binarySearch(int front, int rear) {

        if (front <= rear) {
            int mid = (front + rear) / 2;
            if (search == arr[mid]) {
                sb.append('1').append('\n');
            } else if (search < arr[mid]) {
                binarySearch(front, mid-1);
            } else if (search > arr[mid]) {
                binarySearch(mid+1, rear);
            }
        } else {
            sb.append('0').append('\n');
        }
    }
}
