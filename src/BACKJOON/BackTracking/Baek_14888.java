package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14888 {
    // 1. 연산은 무조건 앞에서 부터
    // 2. 최대 최소를 구해라
    // 3. dfs로 완전 탐색 갑니다.
    static int M, Max, min, ans;
    static int[] arr;
    static int[] operator;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());

        M = st1.countTokens();
        arr = new int[M];
        int i =0;
        while (st1.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st1.nextToken());
        }

        operator = new int[4]; // + - * /
        int j =0;
        while (st2.hasMoreTokens()) {
            operator[j++] = Integer.parseInt(st2.nextToken());
        }
        Max =Integer.MIN_VALUE;
        min =Integer.MAX_VALUE;
        ans = arr[0];

        dfs(1);

        System.out.println(Max);
        System.out.println(min);

    }

    static void dfs(int depth) {

        if (depth == M) {
            Max = Math.max(Max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i=0; i<4; i++) {

            if (operator[i] > 0) {
                int save = ans;
                if (i == 0) {
                    operator[0] -= 1;
                    ans += arr[depth];
                    dfs(depth+1);
                    ans = save;
                    operator[0] += 1;
                } else if (i == 1) {
                    operator[1] -= 1;
                    ans -= arr[depth];
                    dfs(depth+1);
                    ans = save;
                    operator[1] += 1;
                } else if (i == 2) {
                    operator[2] -= 1;
                    ans *= arr[depth];
                    dfs(depth+1);
                    ans = save;
                    operator[2] += 1;
                } else {
                    operator[3] -= 1;
                    ans /= arr[depth];
                    dfs(depth+1);
                    ans = save;
                    operator[3] += 1;
                }
            }
        }
    }
}