package z_codeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            // 각 테스트케이스의 N 입력
            int N = Integer.parseInt(br.readLine());

            // N이 2의 거듭제곱인지 확인
            // N이 0보다 크고, N & (N-1) == 0이면 2의 거듭제곱
            if((N%2) == 0) {
                sb.append('#').append(t).append(" YES\n");
            }
            else {
                sb.append('#').append(t).append(" NO\n");
            }
        }
        // 모든 결과를 한 번에 출력
        System.out.print(sb);
    }
}