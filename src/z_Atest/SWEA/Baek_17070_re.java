package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Baek_17070. 파이프 옮기기

public class Baek_17070_re {
    // 1. 가로는 col 인덱스 +1
    //    세로는 row 인덱스 +1
    //    대각선은 row col 인덱스 +1
    // 2. 백트래킹으로 풀래 그냥... 그거 밖에 더 있나? 아 몰랑
    // 3. tail이랑 head 값을 계속 저장해야 현재 상태를 알 수 있다. = > 이렇게 풀면 저장하는 시간이 너무 많이 들어
    // 4. 나아갈 방향이 명확할 때는 굳이 상태를 저장할 배열을 쓰지 않는게 좋아보여 => 시간이 너무 많이듬
    // 5. 명확하다는 것이 무엇이냐면, a 이면 b,c 의 상태로 나아가고 b이면 a, b, c 로 나아가는 그런...?
    // 6. 여튼 현재 상태를 저장하는 방법을 배웠다.
    static int[][] arr;
    static int N, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        dfs(0, 1, 0);

        System.out.println(count);
    }

    static void dfs(int headR, int headC, int dir) {
        if (headR == N - 1 && headC == N - 1) {
            count++;
            return;
        }

        if (dir == 0 || dir == 1) {
            if (headC + 1 < N && arr[headR][headC + 1] != 1) {
                headC += 1;
                dfs(headR, headC, 0);
                headC -= 1;
            }
        }
        if (headR + 1 < N && headC + 1 < N
                && arr[headR][headC + 1] != 1
                && arr[headR + 1][headC] != 1
                && arr[headR + 1][headC + 1] != 1) {
            headR += 1;
            headC += 1;
            dfs(headR, headC, 1);
            headR -= 1;
            headC -= 1;
        }
        if (dir == 2 || dir == 1) {
            if (headR + 1 < N && arr[headR + 1][headC] != 1) {
                headR += 1;
                dfs(headR, headC, 2);
                headR -= 1;
            }
        }
    }
}


