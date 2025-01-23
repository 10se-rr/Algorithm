package BACKJOON.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Baek_6497. 전력난
//
// 총 거리의 합이 int 범위이다.
// 입력
// N  M
// x y z(거리)
// 모든 집을 직 간접적으로 왕래할 수 있다고 말해두었다.
// 서메이션 z 를 total 이라고 명명
// 모든 엣지를 넣고 크루스칼을 돌리면서 최소 MST를 쓴다
public class Baek_6497 {

    static class Edge implements Comparable<Edge> {

        int X;
        int Y;
        int Z;

        Edge(int X, int Y, int Z) {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.Z, o.Z);
        }
    }

    static int[] p;
    static int[] rank;
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str = br.readLine().trim();

        while (!str.equals("0 0")) {
            st = new StringTokenizer(str);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p = new int[N];
            rank = new int[N];
            size = new int[N];
            makeSet(N);

            Queue<Edge> Q = new PriorityQueue<>();
            int total = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                Q.add(new Edge(x, y, z));
                total += z;
            }
            int sum = 0;
            while (!Q.isEmpty()) {

                Edge curr = Q.poll();

                int x = curr.X;
                int y = curr.Y;
                int z = curr.Z;

                if (findSet(x) == findSet(y)) continue;

                union(x, y);
                sum += z;
                if (size[findSet(x)]==N || size[findSet(y)] == N) break;
            }
            sb.append(total - sum).append('\n');
            str = br.readLine().trim();
        }
        System.out.println(sb);
    }

    static void makeSet(int N) {
        for (int i = 0; i < N; i++) {
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

    static void union(int a, int b) {

        int A = findSet(a);
        int B = findSet(b);

//        if (A == B)  중복 코드
//            return;

        if (rank[A] < rank[B]) {
            p[A] = B;
            size[B] += size[A];
        } else if (rank[A] > rank[B]) {
            p[B] = A;
            size[A] += size[B];
        } else {
            p[B] = A;
            rank[A]++;
            size[A] += size[B];
        }
    }
}
