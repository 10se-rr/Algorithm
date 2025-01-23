package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution20 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=1; t < T+1; t++ ) {
            String ox= br.readLine();
            int score =0;
            int sum =0;
            // 스트링을 어레이로 만드는거 기억이 안 남. StringToArray? 아 ... 공부해야지

            for (int i=0; i<ox.length();i++) {
                if (ox.charAt(i) == 'O') {
                    sum++;
                    score += sum;
                } else {
                    sum = 0;
                }
            }

            System.out.println(score);
        }
    }
}

// 큐 써서 연속된 거 끊기면 점수 채킹 하는 식으로 하고 싶었지만,
// 구현 실패!
// 마지막 급해서 카운트 해서 풀었음
//