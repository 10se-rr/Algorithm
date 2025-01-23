package MonthltyTest3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_cheese {

    static int max, available, count, N;
    static int[][] cheese;
    static boolean[][] visited, tmp;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            N = Integer.parseInt(br.readLine());

            cheese = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 각각의 테스트 케이스 마다 초기화
            max = 1; //가장 처음 맥스는 1이라는 점을 명심하자
            available = N * N;
            visited = new boolean[N][N]; // 요정이 먹기 위해 방문한 곳
            tmp = new boolean[N][N]; // 각 날짜마다 dfs 방문을 표시
            int day = 1;

            while (available > 0) { // avilable 양수가 아니면, 더 이상 먹을 치즈가 없기 떄문에 멈춤
                eat(day++);// 해당 날짜의 치즈를 먹기! 그 후 day++;
                count = 0; // 각각의 날마다 치즈 덩어리 수를 계산

                //각 단계 별로 미방문 지점에서 시작!
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!tmp[i][j]) {
                            dfs(i, j);
                            count++; // 해당 지점에서 dfs가 종료되었다는 말은 1개의 덩어리가 끝남
                        }
                    }
                }
                max = Math.max(max, count);
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

    static void eat(int day) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] == day) {
                    visited[i][j] = true; // 해당 치즈는 요정이 먹었음
                    available--; // 치즈를 먹을 대마다 치즈 1개씩 빼줌.
                }
                tmp[i][j] = visited[i][j]; // 각 날 따 마다 visited배열로 바꿔줌.
            }
        }
    }

    static void dfs(int row, int col) {

        // 해달 날짜에 방문을 하지 않았다면 실행
        if (!tmp[row][col]) {
            tmp[row][col] = true;

            // 델타 탐색을 이용하여 다음 치즈를 탐색 + 변수가 범위를 확인
            for (int d = 0; d < 4; d++) {
                if (0 <= row + dr[d] && row + dr[d] < N && 0 <= col + dc[d] && col + dc[d] < N
                        && !tmp[row + dr[d]][col + dc[d]]) {

                    dfs(row + dr[d], col + dc[d]);
                }
            }
        }
    }
}
