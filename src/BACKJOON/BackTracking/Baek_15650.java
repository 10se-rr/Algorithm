package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15650 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);

        System.out.println(sb);

    }

    static void dfs(int N, int M, int depth) {

        if (depth == M) {

            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visit[i] && (depth==0 || arr[depth-1] < i+1)) {
                visit[i] = true;
                arr[depth] = i + 1;

                dfs(N, M, depth + 1);

                visit[i] = false;
            }
        }
    }
}