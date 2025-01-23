package BACKJOON.DPonTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Baek_15681. 트리와 쿼리
//
//일단 트리를 만들고,
//dfs를 돌면서 자식 노드에 부모 노드를 기억 시키고
//후위 순회 뒤에서 부터 서브트리의 사이즈 값을 더하자.

public class Baek_15681 {

    static class Node {
        int num;
        int parent;
        int subSize = 1;
        List<Node> adjList = new ArrayList<>();

        Node(int num) {
            this.num = num;
        }
    }

    static Node[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        //초기화 작업
        nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        // input 주입
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].adjList.add(nodes[b]);
            nodes[b].adjList.add(nodes[a]);
        }
        visited = new boolean[N + 1];
        visited[R] = true;
        dfs(nodes[R]);

        for (int i=0; i<Q; i++) {
            int q = Integer.parseInt(br.readLine());

            sb.append(nodes[q].subSize).append('\n');
        }
        System.out.println(sb);
    }

    // dfs를 돌면서 부모 노드를 넣어줌
    public static void dfs(Node curr) {

        for (Node next : curr.adjList) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                next.parent = curr.num;
                dfs(next);
            }
        }
        nodes[curr.parent].subSize += curr.subSize;
    }
}
