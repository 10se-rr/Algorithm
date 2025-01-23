package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2606 {
    static boolean[][] stat;
    static boolean[] visited;
    static int count=0;
    static int node,link;


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine().trim());
        link = Integer.parseInt(br.readLine().trim());

        stat = new boolean[node+1][node+1]; // 0 은 쓰지 않는 걸로
        visited = new boolean[node+1];

        for (int i=0; i<link; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            stat[A][B] = true;
            stat[B][A] = true;
        }
        dfs(1);

        System.out.println(count-1); // 1번 노드 뺴줘야함

    }
    static void dfs(int start) {

        visited[start] = true;
        count++; // 바이러스 감염됨.

        for (int i =1; i<=node; i++) {
            if(stat[start][i] && !visited[i]) // 연결 되어야하고 아직 방문도 안 해야함.
                dfs(i);
        }
    } // 연결된 아이들이 모두 방문되면 갈 곳 없어서 돌아옴.
}
