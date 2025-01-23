package z_Atest.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test2 {
    static class Node {

        int num;
        int min = 0;
        List<Edge> adjList = new ArrayList<>();

        Node(int num) {
            this.num = num;
        }
    }

    static class Edge {
        int toR;
        int toC;
        int weight;

        Edge(int toR, int toC, int weight) {
            this.toR = toR;
            this.toC = toC;
            this.weight = weight;
        }
    }


    static int N;
    static boolean[][] visited;
    static Node[][] nodes;
    static int[] dc = {0, 1, -1, 0};
    static int[] dr = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N][N];
            visited = new boolean[N][N];
            visited[0][0] = true;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    nodes[i][j] = new Node(Integer.parseInt(st.nextToken()));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    int height = nodes[i][j].num;

                    for (int d = 0; d < 4; d++) {
                        int nextR = i + dr[d];
                        int nextC = j + dc[d];
                        int nextH = nodes[nextR][nextC].num;
                        if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N) {
                            if (height < nextH) {
                                nodes[i][j].adjList.add(new Edge(nextR, nextC, 2 * (nextH - height)));
                            } else if (height > nextH) {
                                nodes[i][j].adjList.add(new Edge(nextR, nextC, 0));
                            } else {
                                nodes[i][j].adjList.add(new Edge(nextR, nextC, 1));
                            }
                        }
                    }
                }
            }
        }
    }
    static void bfs (Node curr) {

        Queue<Node> Q = new LinkedList<>();
        Q.add(curr);

        while (!Q.isEmpty()) {



        }
    }
}