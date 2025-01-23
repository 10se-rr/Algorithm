package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_fungitiveArrest_re {
    // 탈출한지 한 시간 뒤, 어느 맨홀 한 곳에서 은신 중
    // 터널끼리 연결되어 있다면 이동가능 위치의 개수 계산
    // 시간당 1의 거리
    // 0번 - 모두 false;
    // 1번 - 상하좌우 true;
    // 2번 - 상하 true;
    // 3번 - 좌우 true;
    // 4번 - 상우 true;
    // 5번 - 하우 true;
    // 6번 - 하좌 true;
    // 7번 - 상좌 true;

    static class Node {
        int R, C, pipe;

        public Node(int r, int c, int pipe) {
            R = r;
            C = c;
            this.pipe = pipe;
        }

        // 파이프에 따른 이동 가능한 방향을 동적으로 계산
        public boolean canMove(int direction) {
            switch (this.pipe) {
                case 0:
                    return false;
                case 1:
                    return direction == 0 || direction == 1 || direction == 2 || direction == 3;
                case 2:
                    return direction == 0 || direction == 2;
                case 3:
                    return direction == 1 || direction == 3;
                case 4:
                    return direction == 0 || direction == 3;
                case 5:
                    return direction == 2 || direction == 3;
                case 6:
                    return direction == 2 || direction == 1;
                case 7:
                    return direction == 0 || direction == 1;
                default:
                    return false;
            }
        }
    }

    static Node[][] arr;
    static int N, M, R, C, L;
    static int count, time;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken()); // 맨홀 들어가는 시간도 포함해야 함(조심!!!)

            arr = new Node[N][M]; // 노드를 담는 배열;

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < M; c++) {
                    arr[r][c] = new Node(r, c, Integer.parseInt(st.nextToken()));
                }
            }

            count = 0;
            time = 0;
            bfs(arr[R][C]);
            sb.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static void bfs(Node start) {
        Queue<Node> Q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        Q.add(start);
        visited[start.R][start.C] = true; // 항상 방문 체크를 한 뒤 바로 체크를 하다 보면, 스타트가 체크가 안 됨. 주의
        Node curr;

        while (!Q.isEmpty() && time < L) {
            int size = Q.size(); // 아래 사이즈가 계속 변함. 디버깅 완료
            for (int i = 0; i < size; i++) {
                curr = Q.poll();
                count += 1;

                for (int d = 0; d < 4; d++) { // 상하좌우 탐색
                    int nextR = curr.R + dr[d];
                    int nextC = curr.C + dc[d];

                    if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                        Node nextNode = arr[nextR][nextC];
                        if (!visited[nextR][nextC] && curr.canMove(d) && nextNode.canMove((d + 2) % 4)) {
                            visited[nextR][nextC] = true;
                            Q.add(nextNode);
                        }
                    }
                }
            }
            time += 1;
        }
    }
}
