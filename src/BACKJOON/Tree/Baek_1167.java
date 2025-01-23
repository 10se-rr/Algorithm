package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Baek_1167. 트리의 지름
//
// 전수 탐색을 통해서 해결하려 했는데,
// 시간 초과가 나왔다.
// 트리라는 점에서 착안하여서 한 지점에서 가장 먼곳을 찾은 다음
// 그 점에서 가장 먼 거리(지름)을 찾고자 했다.

public class Baek_1167 {

    static class Node {
        int num;
        int dis;
        List<Node> adjList = new ArrayList<>();

        Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    static int V;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input 입력
        V = Integer.parseInt(br.readLine());
        nodes = new Node[V + 1];

        // Node 초기화
        initNodes();

        // 인접 리스트 넣기
        for (int i = 1; i <= V; i++) {

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int nextNum = Integer.parseInt(st.nextToken());

            while (nextNum != -1) {

                int distance = Integer.parseInt(st.nextToken());
                nodes[num].adjList.add(new Node(nextNum, distance));

                nextNum = Integer.parseInt(st.nextToken());
            }
        }

        findR();

        System.out.println(Max);
    }

    static void initNodes() {
        for (int i = 1; i <= V; i++) {
            nodes[i] = new Node(i, 0);
        }
    }

    static int Max = -1;
    static boolean[] visited;
    static int farthestNode = 1;
    static void findR() {
        visited = new boolean[V + 1];

        visited[1] = true;
        dfs(nodes[1], 0);
        visited[1] = false;

        Max = 0;
        visited[farthestNode] = true;
        dfs(nodes[farthestNode],0);
    }


    static void dfs(Node curr, int tmp) {

        if (Max < tmp) {
            Max = tmp;
            farthestNode = curr.num;
        }

        for (Node next : curr.adjList) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(nodes[next.num],tmp + next.dis);
                visited[next.num] = false;
            }
        }
    }
}

