package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_1654.랜선 자르기

// 최대 길이이기 때문에 UpperBound를 구해야한다.

public class Baek_1654_re {

    static int K,N;
    static long total;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 가지고 있는 수
        N = Integer.parseInt(st.nextToken()); // 만들어야 하는 수

        int[] arr = new int[K];

        for (int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long result = binarySearch(arr);

        System.out.println(result);
    }
    static long binarySearch(int[] arr) {

        long front = 0;
        long rear = (long)Integer.MAX_VALUE + 1 ; // Integer 래퍼클래스이므로 + 1 이 들어가는 순간 해당 객체는 int 범위를 넘어가게 됨.

        while (front < rear) {
            long mid = (front + rear)/2; // rear 의 끝값이 int형 최대값이기 때문에 front + rear 가 int 형을 벗어날 수 있다.

            total = 0; // 초기화
            total = sum(mid,arr);

            if (total < N) { // 적게 잘렸다는 말은 mid 가 UpperBound 보다 크다는 뜻이다.
                rear = mid;
            } else { // 더 많거나 같은 숫자로 뽑혔다는 것은 mid 가 UpperBound 보다 작거나 같다는 뜻이다.
                front = mid + 1;
            }
        }
        return front - 1; // UpperBound = front - 1
    }
    static long sum(long length, int[] arr) {

        for (int i=0; i<K; i++) {
            total += arr[i]/length;
        }
        return total;
    }
}
