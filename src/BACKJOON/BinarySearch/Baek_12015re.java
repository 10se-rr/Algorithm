package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baek_12015. 가장 긴 증가하는 부분 수열 2
public class Baek_12015re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastIdx = 0;
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (arr[lastIdx] < num) {
                lastIdx += 1;
                arr[lastIdx] = num;
            } else {
                // 이진 탐색 범위를 0부터 lastIdx까지로 지정 (lastIdx + 1)
                int idx = Arrays.binarySearch(arr, 0, lastIdx + 1, num);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                arr[idx] = num;
            }
        }
        // 최장 증가 부분 수열의 길이는 lastIdx + 1
        System.out.println(lastIdx + 1);
    }
}
