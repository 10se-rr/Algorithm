package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baek_11725. 트리의 부모 찾기
//
// 고민을 조금 했다.
// 그래프는 그리면 된다지만, 부모 노드를 어떻게 입력해야할까?
// 먼저 그래프를 그린 다음
// 루트 노드인 1을 시작으로 탐색을 하며 부모 노드를 표현하기로 마음 먹었다.
public class Baek_11725 {

    static class Node {

        int num;
        List<Node> adjList = new ArrayList<>();

        Node(int num) {
            this.num = num;
        }
    }

    static int N;
    static Node[] nodes;
    static int[] p;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // 노드 객체 초기화
        nodes = new Node[N+1];
        initNodes();

        // 인접리스트 채우기
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].adjList.add(nodes[b]);
            nodes[b].adjList.add(nodes[a]);
        }
        // 부모 배열 초기화
        p = new int[N+1];

        // BFS 탐색 -> p 배열 입력
        bfs(1);

        // 출력
        for(int i= 2; i<N+1; i++) {
            sb.append(p[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void initNodes() {
        for (int i = 1; i < N+1; i++) {
            nodes[i] = new Node(i);
        }
    }

    static void bfs(int num) {
        boolean[] visited = new boolean[N+1];
        Queue<Node> Q = new ArrayDeque<>();

        Q.add(nodes[num]);

        while(!Q.isEmpty()) {

            Node curr = Q.poll();

            if (visited[curr.num])
                continue;

            visited[curr.num] = true;

            for (Node next : curr.adjList) {
                if (!visited[next.num]) {
                    p[next.num] = curr.num;
                    Q.add(next);
                }
            }
        }
    }
}







