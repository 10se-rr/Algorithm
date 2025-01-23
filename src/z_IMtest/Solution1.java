package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
    ///1 == 아래로 2 == 위로 100x100
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {

            int N = Integer.parseInt(br.readLine());

            int[][] magnetic = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    magnetic[i][j] = Integer.parseInt(st.nextToken());
            }

            int final_total = 0;
            for (int j = 0; j < N; j++) {
                int down = -1;
                int up = N;
                for (int i = 0; i < N; i++) {
                    if (magnetic[i][j] == 0)
                        continue;
                    else if (magnetic[i][j] == 1) {
                        down = i;
                        break;
                    }
                }

                if (down==-1)
                    continue;

                for (int i = 99; 0 <= i; i--) {
                    if (magnetic[i][j] == 0) {
                        continue;
                    }
                    else if (magnetic[i][j] == 2) {
                            up = i;
                            break;
                    }
                }
                if (up==100)
                    continue;

                int now = 1;
                int total = 2;

                for (int i = down + 1; i < up; i++) {
                    if ((magnetic[i][j] != now) && (magnetic[i][j] != 0)) {
                        ++total;
                        if (now == 1)
                            now = 2;
                        else
                            now = 1;
                    }
                }
                final_total += total / 2;
            }
            System.out.println("#" + t + " " + final_total);
        }
    }
}

// 1.가장 위쪽 N극 위치와 가장 아래쪽 S극 위치를 찾는다.
// 2. total=2 를 시작, 가장위N에서 부터 가장 아래S 까지 훓으면서 극이 바뀌는 순간 total++ 카운트 한다.
// 3. 마지막에 total/2 한 뒤, finalTotal에 더해준다.