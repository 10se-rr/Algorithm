package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5653 {
    // X시간 동안 비활성화 -> X시간 동안 활성화
    // 죽은 상태로 그리드 차지
    // 1시간 동안만 상하좌우 번식
    // 번식된 줄기세포는 비활성 상태
    // 막힘
    // 생명력 높은 놈이 혼자 차지
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // 배양 시간

            int[][] arr = new int[N][M];
            for (int n = 0; n < N; n++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[n][m] = Integer.parseInt(st1.nextToken());// X : 각 그리드의 줄기 세포 생명력
                }
            }





        }
    }
}