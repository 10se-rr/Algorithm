package BACKJOON.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_3665 {

    static List<Integer>[] adjList;
    static Stack<Integer> stack;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] inDeg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {

            int n = Integer.parseInt(br.readLine().trim());

            adjList = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            visited = new boolean[n + 1];

            inDeg = new int[n + 1];

            while (st.hasMoreTokens()) {
                int curr = Integer.parseInt(st.nextToken());
                visited[curr] = true;
                for (int i = 1; i <= n; i++) {
                    if (!visited[i]) {
                        adjList[curr].add(i);
                        inDeg[i]++;
                    }
                }
            }

            int m = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                inDeg[b]++;
                adjList[b].remove(Integer.valueOf(a));
                inDeg[a]--;
            }
            stack = new Stack();
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (inDeg[i] == 0) {
                    topologicalSort(i);
                }
            }

            if (stack.size() == n) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(' ');
                }
                sb.append('\n');
            } else if (stack.size() < n){
                sb.append("IMPOSSIBLE").append('\n');
            } else {
                sb.append('?').append('\n');
            }
        }
        System.out.println(sb);
    }

    static void topologicalSort(int i) {

        visited[i] = true;
        for (int x : adjList[i]) {
            if (!visited[x]) {
                topologicalSort(x);
            }
        }
        stack.push(i);
    }
}