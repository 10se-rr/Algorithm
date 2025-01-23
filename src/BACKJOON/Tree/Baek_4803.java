package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_4803. 트리
//
// 입력값 n, m
//
public class Baek_4803 {
    static int[] p;
    static int[] rank;
    static boolean[] flag;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input = br.readLine();
        int t = 1;
        while (!input.equals("0 0")) {

            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            p = new int[n + 1];
            rank = new int[n + 1];
            flag = new boolean[n + 1];
            makeSet();

            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int A = findSet(a);
                int B = findSet(b);

                if (flag[A] || flag[B] || A==B) {
                    flag[A] = true;
                    flag[B] = true;
                    continue;
                }
                union(A, B);
            }
            sb.append(answer(t++)).append('\n');
            input = br.readLine();
        }
        System.out.println(sb);
    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    static int findSet(int x) {

        if (p[x] == x) {
            return x;
        }
        return p[x] = findSet(p[x]);
    }

    static void union(int A, int B) {

        if (rank[A] < rank[B]) {
            p[A] = B;
        } else if (rank[A] > rank[B]) {
            p[B] = A;
        } else {
            p[B] = A;
            rank[A] += 1;
        }
    }

    static String answer(int t) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int I = findSet(i);
            if (!flag[I]) {
                flag[I] = true;
                total += 1;
            }
        }
        String str = "Case " + t + ": ";

        if (total == 0) {
            return str + "No trees.";
        } else if (total == 1) {
            return str + "There is one tree.";
        } else {
            return str + "A forest of " + total + " trees.";
        }
    }
}
