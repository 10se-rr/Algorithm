package BACKJOON.MST.Kruskal;

// Baek_21924.도시 건설
//
// 전형적인 MST문제이다.
// 도로의 개수의 최대값이 5*10^5 이고, 비용의 최대값이 10^6이므로
// 총 비용의 최댓값은 5*10^11 이다. 따라서 총 비용의 타입은 long으로 둬야한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_21924re {

    static class Edge implements Comparable<Edge> {
        int A;
        int B;
        int W;

        Edge(int A, int B, int W) {
            this.A = A;
            this.B = B;
            this.W = W;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.W, o.W);
        }
    }

    static int[] p;
    static int[] rank;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //어차피 더하는건 sum에서만 쓸거임. 걍 int ㄱㄱ

        p = new int[N + 1];
        rank = new int[N + 1]; // 도로 개수가 많아서, 최적화 하고 싶음
        edges = new Edge[M];
        int component = N;
        makeSet(N);

        long before = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(A, B, W);
            before += W;
        }
        Arrays.sort(edges);

        long after = 0;
        for (int i = 0; i < M; i++) {

            Edge curr = edges[i];

            if (findSet(curr.A) == findSet(curr.B))
                continue;

            union(curr.A, curr.B);
            after += curr.W;
            component--;
        }

        if (component == 1) {
            System.out.println(before - after);
        } else {
            System.out.println(-1);
        }
    }

    static void makeSet(int N) {
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    static int findSet(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = findSet(p[x]);
    }

    static void union(int A, int B) {
        int a = findSet(A);
        int b = findSet(B);

        if (rank[a] > rank[b]) {
            p[b] = a;
        } else if (rank[a] < rank[b]) {
            p[a] = b;
        } else {
            p[a] = b;
            rank[b]++;
        }
    }
}