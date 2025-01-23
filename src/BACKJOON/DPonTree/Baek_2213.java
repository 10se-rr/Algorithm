package BACKJOON.DPonTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_2213 {

    static class Node {
        int num;
        int included;
        int excluded;
        Node parent;
        List<Node> adjList = new ArrayList<>();

        Node(int num, int weight) {
            this.num = num;
            this.included = weight;
            this.excluded = 0;
        }
    }

    static Node[] nodes;
    static boolean[] visited;
    static int N;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        // 노드 생성
        nodes = new Node[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, weight);
        }

        // 간선 주입
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].adjList.add(nodes[b]);
            nodes[b].adjList.add(nodes[a]);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(nodes[1]);

        if (nodes[1].included >= nodes[1].excluded) {
            sb.append(nodes[1].included).append('\n');
            result.add(1);
            reconstruct(nodes[1], true);
        } else {
            sb.append(nodes[1].excluded).append('\n');
            reconstruct(nodes[1], false);
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(Node curr) {
        for (Node child : curr.adjList) {
            if (!visited[child.num]) {
                visited[child.num] = true;
                child.parent = curr;
                dfs(child);
                curr.included += child.excluded;
                curr.excluded += Math.max(child.included, child.excluded);
            }
        }
    }

    static void reconstruct(Node node, boolean isParentIncluded) {
        if (isParentIncluded) {
            for (Node child : node.adjList) {
                if (child != node.parent) {
                    reconstruct(child, false);
                }
            }
        } else {
            if (node.included > node.excluded) {
                result.add(node.num);
                for (Node child : node.adjList) {
                    if (child != node.parent) {
                        reconstruct(child, true);
                    }
                }
            } else {
                for (Node child : node.adjList) {
                    if (child != node.parent) {
                        reconstruct(child, false);
                    }
                }
            }
        }
    }
}
