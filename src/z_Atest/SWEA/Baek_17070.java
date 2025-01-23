package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Baek_17070. 파이프 옮기기

public class Baek_17070 {
    // 1. 가로는 col 인덱스 +1
    //    세로는 row 인덱스 +1
    //    대각선은 row col 인덱스 +1
    // 2. 백트래킹으로 풀래 그냥... 그거 밖에 더 있나? 아 몰랑
    // 3. tail이랑 head 값을 계속 저장해야 현재 상태를 알 수 있다.
    // 4.
    static int[][] arr;
    static int[] dr = {0, 1, 1};  // 가로 이동 , 대각 이동 , 세로 이동
    static int[] dc = {1, 1, 0};

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
        dfs(0,1,0,0);

        System.out.println(count);
    }

    static void dfs(int headR, int headC, int tailR, int tailC) {
        if (headR == N - 1 && headC == N - 1) {
            count++;
            return;
        }
        // 0열 가로  1열 대각선 2열 세로
        boolean[] available = new boolean[3];
        // 가로
        if (headR - tailR == 0 && headC - tailC == 1) {
            available[2] = true;
        }//세로
        else if (headR - tailR == 1 && headC - tailC == 0) {
            available[0] = true;
        }

        for (int d = 0; d < 3; d++) {

            if (!available[d]) {
                if (d == 0 && headC + 1 < N && arr[headR][headC + 1] != 1) {
                    int tmpR = tailR;
                    int tmpC = tailC;
                    tailR = headR;
                    tailC = headC;
                    headC += 1;
                    dfs(headR, headC, tailR, tailC);
                    headC -= 1;
                    tailR = tmpR;
                    tailC = tmpC;
                } else if (d == 1 && headR + 1 < N && headC + 1 < N
                        && arr[headR][headC + 1] != 1
                        && arr[headR + 1][headC] != 1
                        && arr[headR + 1][headC + 1] != 1) {
                    int tmpR = tailR;
                    int tmpC = tailC;
                    tailR = headR;
                    tailC = headC;
                    headR += 1;
                    headC += 1;
                    dfs(headR, headC, tailR, tailC);
                    headR -= 1;
                    headC -= 1;
                    tailR = tmpR;
                    tailC = tmpC;
                } else if (d == 2 && headR + 1 < N && arr[headR + 1][headC] != 1) {
                    int tmpR = tailR;
                    int tmpC = tailC;
                    tailR = headR;
                    tailC = headC;
                    headR += 1;
                    dfs(headR, headC, tailR, tailC);
                    headR -= 1;
                    tailR = tmpR;
                    tailC = tmpC;
                }
            }
        }
    }
}

