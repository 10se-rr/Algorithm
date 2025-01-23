package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baek_2644_촌수계산
public class Baek_2644 {
    static int N;
    static int A,B;
    static int M;
    static List<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine().trim());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine().trim());

        adjList = new ArrayList[N+1];

        for (int i=1; i<N+1;i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[P].add(C);
            adjList[C].add(P);
        }
        visited = new boolean[N+1];
        visited[A] = true;
        dfs(0,A,B);
        System.out.print(-1);

    }
    static void dfs(int depth, int A, int B) {
        if (A==B) {
            System.out.println(depth);
            System.exit(0);
        }
        for (int i=0; i < adjList[A].size(); i++) {
            if (!visited[adjList[A].get(i)]) {
                visited[adjList[A].get(i)] = true;
                dfs(depth + 1, adjList[A].get(i), B);
                visited[adjList[A].get(i)] = false;
            }
        }
    }
}
