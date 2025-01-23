package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_fugitiveArrest {
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
        boolean[] able = new boolean[4]; // 상 좌 하 우 ( 이런거도 신경 써야함?)
        List<Node> adjList = new ArrayList<>(); // 그리고 가능한 것들 처리 할 것.

        public Node(int r, int c, int pipe) {
            R = r;
            C = c;
            this.pipe = pipe;
        }

        public void makeA() {
            switch (this.pipe) {
                case 0:
                    break;
                case 1:
                    able[0] = true; // 상
                    able[1] = true; // 좌
                    able[2] = true; // 하
                    able[3] = true; // 우
                    break;
                case 2:
                    able[0] = true; // 상
                    able[2] = true; // 하
                    break;
                case 3:
                    able[1] = true; // 좌
                    able[3] = true; // 우
                    break;
                case 4:
                    able[0] = true; // 상
                    able[3] = true; // 우
                    break;
                case 5:
                    able[2] = true; // 하
                    able[3] = true; // 우
                    break;
                case 6:
                    able[2] = true; // 하
                    able[1] = true; // 좌
                    break;
                case 7:
                    able[0] = true; // 상
                    able[1] = true; // 좌
                    break;
            }
        }
    }

    static Node[][] arr;
    static int N, M, R, C, L;
    static int count,time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] dr = {1, 0}; // 하 우
        int[] dc = {0, 1};
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
                    arr[r][c].makeA();
                }
            }

            // 간선을 만들어 보자~! 아 힘들당
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int nextR;
                    int nextC;
                    for (int d = 0; d < 2; d++) { // d =0 하 able[0] 상 able[2] 하
                        nextR = r + dr[d];        // d =1 우 able[1] 좌 able[3] 우
                        nextC = c + dc[d];
                        if (nextR < N && nextC < M) {
                            if (arr[r][c].able[d + 2] && arr[nextR][nextC].able[d]) {
                                arr[r][c].adjList.add(arr[nextR][nextC]);
                                arr[nextR][nextC].adjList.add(arr[r][c]);
                            }
                        }
                    }
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
        visited[start.R][start.C] =true; // 항상 방문 체크를 한 뒤 바로 체크를 하다 보면, 스타트가 체크가 안 됨. 주의
        Node curr;
        while (!Q.isEmpty() && time<L) {

            int size =Q.size(); // 아래 사이즈가 계속 변함 ㅋ... 디버깅 완료
            for (int i = 0; i < size; i++) {
                curr = Q.poll();
                //visited[curr.R][curr.C] = true; -> 여기서 처리하면 추가하면서 중복 추가 할 수 있음. 조심!!!
                count += 1;
                for (Node x : curr.adjList) {
                    if (!visited[x.R][x.C]) {
                        visited[x.R][x.C] = true;
                        Q.add(x);
                    }
                }
            }
            time += 1;
        }
    }
}