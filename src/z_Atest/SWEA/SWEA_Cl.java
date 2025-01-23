package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_Cl {
    // 가장 높은 봉우리에서 시작한다.
    // 높은 지형에서 낮은 지형으로
    // 가로 세로  => 델타
    // 최대 K 깊이 만큼 지형을 깍는 공사 가능
    // 가장 긴 등상로를 찾아 그 길이를 출력
    // 딱 한 곳만 공사 가능
    static Node[][] arr;
    static boolean[][] visited;
    static int N; //격자 크기
    static int K; // 최대 공사 가능 깊이
    static int highest;
    static int maxDistance;

    static class Node {
        int R, C, Height; // 해당 인스턴스의 행 열 높이

        List<Node> adjList = new ArrayList<>(); // 이동 가능 인스턴스 모을 것

        public Node(int r, int c, int height) {
            R = r;
            C = c;
            Height = height;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 각각의 인스턴스 생성하고 필드값 넣기 + 제일 높은 값 구하기
            highest = 0;
            arr = new Node[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = new Node(r, c, Integer.parseInt(st.nextToken()));
                    highest = Math.max(highest, arr[r][c].Height);
                }
            }
            // 간선 생성
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int nextR;
                    int nextC;
                    for (int d = 0; d < 4; d++) {
                        nextR = r + dr[d];
                        nextC = c + dc[d];
                        if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N) {
                            arr[r][c].adjList.add(arr[nextR][nextC]);
                        }
                    }
                }
            }
            visited = new boolean[N][N];
            maxDistance = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (arr[r][c].Height == highest) {
                        visited[r][c] = true;
                        dfs(arr[r][c], K,1);
                        visited[r][c] = false;
                    }
                }
            }
            sb.append(maxDistance).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(Node node, int K, int distance) {

        for (Node x : node.adjList) {
            if (!visited[x.R][x.C]) {
                if (x.Height < node.Height) {
                    visited[x.R][x.C] = true;
                    dfs(x, K, distance + 1);
                    visited[x.R][x.C] = false;
                } else {
                    if (x.Height - K < node.Height) {
                        visited[x.R][x.C] = true;
                        int tmp = x.Height;
                        x.Height = node.Height - 1;
                        dfs(x, 0 , distance + 1);
                        x.Height = tmp;
                        visited[x.R][x.C] = false;
                    } else {
                        if (distance > maxDistance)
                            maxDistance = distance;
                    }
                }
            }
        }
        if (distance > maxDistance)
            maxDistance = distance;
    }
}
