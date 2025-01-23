package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Baek_1967.트리의 지름
//
//
public class Baek_1967 {

    static class Node {
        int num;
        int dis;
        List<Node> adjList = new ArrayList<>();

        Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    static int N;
    static int Max, farthest;
    static boolean[] visited;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());



        // 초기화
        nodes = new Node[N+1];
        visited = new boolean[N+1];
        init();
        farthest = 1;
        Max = -1;

        // 간선 받기
        StringTokenizer st;
        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            nodes[num].adjList.add(new Node(next,dis));
            nodes[next].adjList.add(new Node(num, dis));

        }

        visited[1] = true;
        dfs(nodes[1], 0);
        visited[1] = false;

        visited[farthest] = true;
        dfs(nodes[farthest],0);

        System.out.println(Max);

    }

    static void init() {

        for (int i=1; i<=N; i++) {
            nodes[i] = new Node(i, 0);
        }
    }

    static void dfs(Node curr, int tmp) {

        if (Max<tmp) {
            Max = tmp;
            farthest = curr.num;
        }

        for (Node next : curr.adjList) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(nodes[next.num], tmp + next.dis);
                visited[next.num] = false;
            }
        }
    }
}
