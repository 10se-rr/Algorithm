package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14889 {
    // 1. 의무 참석 아님
    // 2. N은 짝수

    // 어떻게 A팀과 B팀을 나눌지를 생각하는 문제이다.
    // 그래서 boolean으로 dfs를 통해서 N/2을 ture로 만드는 작업을 진행하였다.
    static boolean[] arr;
    static int[][] S; // 여기에 A팀에 들어갈 사람은 true B팀에 들어갈 사람은 false로 표시함.
    static StringTokenizer st;
    static int N, countA,countB, minDiff;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        S = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr = new boolean[N];
        minDiff = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.print(minDiff);
        br.close();
    }
    static void dfs(int depth, int start) {

        if (depth == N/2) {
            countA=0;
            countB=0;
            counter();
            int diff = Math.abs(countA-countB);
            minDiff = Math.min(minDiff, diff);
            if ( diff == 0) {
                System.out.print(0);
                System.exit(0);
            }
            return;
        }

        for (int i= start; i<N/2+depth+1; i++) {

            arr[i] = true;
            dfs(depth+1, i+1);
            arr[i] =false;
        }
    }
    static void counter() {

        for(int i = 0; i<N; i++) {
            for(int j = i; j<N; j++) { // 조합이기 때문에 이런 식으로 for문을 썻음

                if (arr[i] && arr[j]) { // 둘 다 true 라면 countA에 더해주고
                    countA += S[i][j] + S[j][i];
                }else if (!arr[i] && !arr[j]) { // 둘 다 false 라면 countB에 더해줌.
                    countB += S[i][j] + S[j][i];
                }
            }
        }
    }
}

