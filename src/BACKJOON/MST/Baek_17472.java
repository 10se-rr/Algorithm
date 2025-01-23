package BACKJOON.MST;

// Baek_17472. 다리 만들기 2
//
// 각각의 섬이 가지는 다리 길이를 구할 수 있는 방법이 필요하다.
// 그후 크루스칼 알고리즘으로 최소 신장 트리를 만들면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_17472 {
    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int dis;

        Edge(int a, int b, int dis) {
            this.a = a;
            this.b = b;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dis, o.dis);
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static List<Node>[] nodeList;
    static int N, M, cntIsland;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};


    static Queue<Edge> edges;
    static int[] p;
    static int[] rank;
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nodeList = new ArrayList[6];
        nodeListInit();
        visited = new boolean[N][M];
        cntIsland = findIsland();

        p = new int[cntIsland];
        rank = new int[cntIsland];
        size = new int[cntIsland];

        edges = new PriorityQueue<>();
        makeEdge();

        ///////크루스칼 알고리즘 시작////////
        makeSet();
        int ans = 0;
        int ansSize = 0;
        while (!edges.isEmpty()) {

            Edge curr = edges.poll();

            if (findSet(curr.a) == findSet(curr.b)) continue;

            union(curr.a,curr.b);
            ans += curr.dis;
            ansSize = Math.max(ansSize,size[findSet(curr.a)]);
        }

        if (ansSize == cntIsland) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
    static void nodeListInit() {
        for (int i=0; i<6; i++) {
            nodeList[i] = new ArrayList<>();
        }
    }

    static int findIsland() {

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, num);
                    num += 1;
                }
            }
        }
        return num;
    }

    static void dfs(int row, int col, int num) {


        visited[row][col] = true;
        nodeList[num].add(new Node(row, col));

        for (int d = 0; d < 4; d++) {
            int nextR = row + dr[d];
            int nextC = col + dc[d];

            if(0<=nextR && nextR<N && 0<= nextC && nextC<M && !visited[nextR][nextC] && arr[nextR][nextC] == 1) {
                dfs(nextR, nextC, num);
            }
        }
    }

    static void makeEdge() {

        for (int i=0; i< cntIsland; i++) {
            for (int j=i+1; j<cntIsland; j++) {
                int min = Integer.MAX_VALUE;

                for (Node A : nodeList[i]) {
                    for (Node B : nodeList[j]) {

                        int distance = isBridge(A,B);
                        if (distance> 1) {
                            min = Math.min(min, distance);
                        }
                    }
                }
                if (min < Integer.MAX_VALUE) {
                    edges.add(new Edge(i, j, min));
                }
            }
        }
    }

    static int isBridge(Node A, Node B) {

        int distance = -1;
        int start = -1;
        int end = -1 ;


        if (A.row != B.row && A.col == B.col ) {

            start = Math.min(A.row,B.row);
            end = Math.max(A.row,B.row);
            distance = end - start - 1;

            if (distance < 2 )
                return 0;

            for (int i= start+1; i<end; i++) {

                if (arr[i][A.col] != 0) {
                    return 0;
                }
            }
        } else if (A.row == B.row && A.col != B.col) {

            start = Math.min(A.col,B.col);
            end = Math.max(A.col,B.col);
            distance = end - start - 1;

            if (distance < 2 )
                return 0;

            for (int i= start+1; i<end; i++) {

                if (arr[A.row][i] != 0) {
                    return 0;
                }
            }
        }
        return distance;
    }

    //크루스칼//////////////////////////////////////////
    static void makeSet() {
        for (int i=0; i<cntIsland; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }
    static int findSet(int x) {

        if (p[x] == x) {
            return  x;
        }
        return p[x] = findSet(p[x]);
    }
    static void union(int a, int b) {
        int A = findSet(a);
        int B = findSet(b);

        if (rank[A]>rank[B]) {
            p[B] = A;
            size[A] += size[B];
        } else if (rank[A]<rank[B]) {
            p[A] = B;
            size[B] += size[A];
        } else {
            p[A] = B;
            size[B] += size[A];
            rank[B]++;
        }
    }
}
