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
public class Baek_1967re {

    static class Node {
        int num;
        int dis;

        Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    static int N;
    static int Max, farthest;
    static boolean[] visited;
    static List<Node>[] nodes;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());



        // 초기화
        nodes = new ArrayList[N+1];
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

            nodes[num].add(new Node(next,dis));
            nodes[next].add(new Node(num, dis));

        }

        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;

        visited[farthest] = true;
        dfs(farthest,0);

        System.out.println(Max);

    }

    static void init() {

        for (int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }
    }

    static void dfs(int curr, int tmp) {

        if (Max<tmp) {
            Max = tmp;
            farthest = curr;
        }

        for (Node next : nodes[curr]) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(next.num, tmp + next.dis);
                visited[next.num] = false;
            }
        }
    }
}
