package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// Baek_2110. 공유기 설치
// 거리를 전수조사
// 거리를 기준으로 이분탐색을 하면서
// 각각의 거리에서 공유기 설치 갯수가 C 인 upperBound를 찾을 것

public class Baek_2110re {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int front = 1;
        int rear = arr[N-1] + 1;

        while (front < rear) {

            int mid = (front + rear)/2;

            if(count(mid) >= C) {
                front = mid + 1; // 해당 거리에서도 가능하고, UpperBound를 찾기위해서, front = mid + 1;
            } else {
                rear = mid;
            }
        }
        System.out.println(front-1);
    }
    static int count(int mid) {

        int cnt = 1;
        int lastNum = arr[0];
        for (int i = 1; i<arr.length; i++ ) {
            if(arr[i] - lastNum >= mid) {
                cnt +=1;
                lastNum = arr[i];
            }
        }
        return cnt;
    }
}
