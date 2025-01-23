package BACKJOON.Geometry2;

//Baek_25308.방사형 그래프
//
// 각각의 8방향의 코사인 사인 값을 구해놓고
// 순열을 돌리면서 좌표를 구하자
// 그후 좌표를 이용해서 외적 값 이용
// 백트래킹 가능
// 외적의 값이 음수가 나오면 백트래킹을 하겠다.
// 원순열 이므로 하나를 고정하면 돌아야하는 수가 1/8로 줄어든다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_25308 {

    static double[] cos = {0, 1 / Math.sqrt(2), 1, 1 / Math.sqrt(2), 0, -1 / Math.sqrt(2), -1, -1 / Math.sqrt(2)};
    static double[] sin = {1, 1 / Math.sqrt(2), 0, -1 / Math.sqrt(2), -1, -1 / Math.sqrt(2), 0, 1 / Math.sqrt(2)};
    static int[] arr;
    static int[] p;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화 작업
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[8];
        p = new int[8];
        visited = new boolean[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        p[0] = arr[0]; // 고정
        visited[0] = true;

        for (int i = 1; i < 8; i++) {
            visited[i] = true;
            p[1] = arr[i];
            for (int j = 1; j < 8; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    p[2] = arr[j];
                    dfs(2);
                    visited[j] = false;
                }
            }
            visited[i] = false;
        }

        System.out.println(count);
    }

    static void dfs(int depth) {

        if (!product(depth)) {
            return;
        }
        if (depth >= 7) {
            if (product(depth + 1) && product(depth + 2)) {
                count += 8;
                return;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[depth + 1] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean product(int depth) {

        int a = (depth - 2) % 8;
        int b = (depth - 1) % 8;
        int c = depth % 8;

        double x0 = p[a] * cos[a];
        double y0 = p[a] * sin[a];
        double x1 = p[b] * cos[b];
        double y1 = p[b] * sin[b];
        double x2 = p[c] * cos[c];
        double y2 = p[c] * sin[c];

        return (x0 - x1) * (y2 - y1) - (y0 - y1) * (x2 - x1) >= 0;


    }
}