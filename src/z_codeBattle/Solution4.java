package z_codeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        // 테스트케이스 반복
        for (int t = 1; t <= TC; t++) {

            sb.append('#').append(t).append(' ');

            // 문제를 푼 일수
            int N = Integer.parseInt(br.readLine());

            // 각 일자별 푼 문제의 개수
            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 문제 정보의 개수
            int M = Integer.parseInt(br.readLine());

            // 추천된 문제의 개수를 저장할 배열
            int[] recommendations = new int[N];
            int currentDay = 0; // 현재 문제를 할당할 일자 (0부터 N-1)

            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine().trim());
                String language = st.nextToken();
                int grade = Integer.parseInt(st.nextToken()); // 등급
                int count = Integer.parseInt(st.nextToken()); // 개수

                // 문제를 할당할 일자에 따라 반복
                while (count > 0 && currentDay < N) {
                    // 현재 일자에 남아있는 문제 개수
                    int remaining = A[currentDay];

                    // 현재 일자에 할당할 문제의 개수는 남아있는 문제 개수와 남은 count 중 최소값
                    int assign = Math.min(remaining, count);

                    // 현재 일자에 추천 문제의 개수를 계산
                    if (language.equals("ko") && grade >= 3) {
                        recommendations[currentDay] += assign;
                    }

                    // 현재 일자의 남은 문제 개수를 줄임
                    A[currentDay] -= assign;

                    // count를 줄임
                    count -= assign;

                    // 현재 일자의 문제 할당이 완료되었으면 다음 일자로 이동
                    if (A[currentDay] == 0) {
                        currentDay++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                sb.append(recommendations[i]).append(' ');
            }
            sb.append('\n');
        }
        //출력
        System.out.print(sb);
    }
}
