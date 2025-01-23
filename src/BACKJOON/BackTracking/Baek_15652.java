package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15652 {
    // 1~N 까지 자연수 중에서 M개를 고른 수열
    // 같은 수를 여러번 골라도 됨
    // 비 내림 차순!
    static StringBuilder sb = new StringBuilder();
    static char[] save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        save = new char[2*M];

        dfs(N, M, 0);

        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth) {

        if (depth == M) {
            sb.append(save);
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth == 0 || save[2*(depth - 1)] <= i + 1+'0') {

                save[2*depth] = (char)((i + 1) +'0');
                save[2*depth+1] = ' ';
                dfs(N, M, depth + 1);
            }
        }
    }
}

