package BACKJOON.BinarySearch;

public class BinarySearch {


    static void BinarySearch(int[] arr, int key) {

        int front = 0; // 시작점
        int rear = arr.length - 1; // 끝점
        int idx = -1; // 반환 인덱스

        while (front <= rear) { // 해당 조건을 넘어가면 의미가 없음

            int mid = (front + rear) / 2;

            // 1. 탐색값을 찾으면 멈춤
            if (arr[mid] == key) {
                idx = mid;
            }
            // 2. 탐색값이 중앙값 보다 작다면, 중앙 보다 뒤쪽은 탐색할 필요 없음
            else if (key < arr[mid]) {
                rear = mid - 1;
            }
            // 3. 탐색값이 중앙값 보다 크다면, 중앙 보다 앞쪽은 탐색할 필요 없음
            else if (key > arr[mid]) {
                front = mid + 1;
            }
        }
    }
}
