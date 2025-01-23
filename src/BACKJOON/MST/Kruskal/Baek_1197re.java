package BACKJOON.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baek_1197. 최소 스패닝 트리
//
// 대놓고 크루스칼 알고리즘을 쓰라고 말하고 있음
// (수정) 크루스칼 음수도 가능함
// (수정) 이번에는 rank를 써서 성능 차이를 비교 해보자!
public class Baek_1197re {

    static class Edge implements Comparable<Edge> {

        int A;
        int B;
        int weight;

        Edge(int A, int B, int weight) {
            this.A = A;
            this.B = B;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight - o.weight > 0)
                return 1;
            else if (this.weight - o.weight < 0)
                return -1;
            else
                return 0;
        }
    }

    static int[] p;
    static int[] rank;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        p = new int[V+1];
        rank = new int[V+1];
        makeSet(V);

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[e] = new Edge(A, B, weight);

        }
        Arrays.sort(edges);

        int sum = 0;
        for (int e = 0; e<E; e++) {
            Edge curr = edges[e];

            if (findSet(curr.A) == findSet(curr.B)) {
                continue;
            }
            union(curr.A, curr.B);

            sum += curr.weight;
        }
        System.out.println(sum);
    }

    static void makeSet(int V) {
        for (int i = 1; i<=V; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }
    // pathComp
    static int findSet(int x) {
        if(p[x] == x) {
            return x;
        }
        return p[x] = findSet(p[x]);
    }
    // unionByRank
    static void union(int A, int B) {
        if (findSet(A) == findSet(B))
            return;

        if (rank[A] > rank[B]) {
            p[findSet(B)] = findSet(A);
        } else if (rank[A] < rank[B]) {
            p[findSet(A)] = findSet(B);
        } else {
            p[findSet(A)] = findSet(B);
            rank[B]++;
        }
    }
}

