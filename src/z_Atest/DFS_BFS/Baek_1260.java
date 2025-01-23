package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baek_1260. DFS와 BFS
public class Baek_1260 {
    static List<Integer>[] graph;
    static StringBuilder sb =new StringBuilder();
    static boolean visitedA[];
    static boolean visitedB[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i =1; i<N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        for (int i = 1; i<N+1; i++) {
            graph[i].sort(null);
        }

        visitedA = new boolean[N+1];
        visitedB = new boolean[N+1];

        sb.append(V).append(' ');
        visitedA[V]= true;
        dfs(V);
        sb.append('\n');
        bfs(V);
        System.out.print(sb);
    }

    static void dfs(int V) {

        for (int x : graph[V]) {
            if (!visitedA[x]) {
                sb.append(x).append(' ');
                visitedA[x] = true;
                dfs(x);
            }
        }
    }
    static void bfs(int V) {

        Queue<Integer> Q = new LinkedList<>();

        Q.add(V);
        visitedB[V] = true;
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            sb.append(curr).append(' ');
            for (int x : graph[curr]) {
                if(!visitedB[x]) {
                    visitedB[x] = true;
                    Q.add(x);
                }
            }
        }
    }
}