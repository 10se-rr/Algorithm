package BACKJOON.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baek_1774. 우주신과의 교감
//
// 직간접적으로 연결만 되면 된다.
// 이미 연결 되어 있는 것도 있다.
// 이미 연결된 노드들을 구분하기 위해서 크루스칼 알고리즘을 사용하고 싶다.
public class Baek_1774 {

    static class Edge implements Comparable<Edge> {
        int A;
        int B;
        double dis;

        Edge(int A, int B, double dis) {
            this.A = A;
            this.B = B;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }

    static int[] p;
    static int[] rank;
    static int[] size;
    static int[][] position;
    static int total =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        rank = new int[N + 1];
        size = new int[N + 1];

        makeSet(N);

        position = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            union(A, B);
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new Edge(i, j, distance(i, j)));
            }
        }
        double sum = 0;
        while ( total <N ) {

            Edge curr = edges.poll();

            int a = curr.A;
            int b = curr.B;

            if (findSet(a) == findSet(b))
                continue;

            union(a,b);
            sum += curr.dis;

        }
        String ans = String.format("%.2f",sum);
        System.out.println(ans);
    }

    static void makeSet(int N) {
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            size[i] = 1;
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

        if ( a == b )
            return;

        if (rank[a] < rank[b]) {
            p[a] = b;
            size[b] += size[a];
            total = size[b];
        } else if (rank[a] > rank[b]) {
            p[b] = a;
            size[a] += size[b];
            total = size[a];
        } else {
            p[b] = a;
            size[a] += size[b];
            rank[a]++;
            total = size[a];
        }
    }

    static double distance(int A, int B) {
        return Math.sqrt(Math.pow(position[A][0] - position[B][0], 2) + Math.pow(position[A][1] - position[B][1], 2));
    }
}
