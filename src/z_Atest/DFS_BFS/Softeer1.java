package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Softeer1 {
    static int N,K;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for (int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);
        System.out.print(min);
    }


    static void dfs (int depth, int start, int max) {

        if (max >= min) { // 백트레킹
            return;
        }
        if (depth == K-1 ) { // 마지막 테이프 길이도 생각해야함
            max = Math.max(max, arr[N-1]-arr[start]+1);
            min = Math.min(min, max);
            return;
        }
        for (int i =start; i<=N-K+depth; i++) {
            dfs(depth+1, i+1, Math.max(max,arr[i]-arr[start]+1));
        }
    }
}
