package BACKJOON.MST;

// Baek_9372. 상근이의 여행
//
// 방문한 곳을 또 방문해도 된다고 했기에 이어지기만 해도 됨.
// 항상 연결 그래프 이다.
// 최소의 연결만을 하면 간선 갯수는 무조건 N-1 아님?
// 뭐지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i=0; i<M; i++) {
                br.readLine();
            }
            sb.append(N-1).append('\n');
        }
        System.out.println(sb);
    }
}
