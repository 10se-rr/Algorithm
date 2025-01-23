package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16 {
//두 사각형을 놓았을 때,
//가장 왼쪽 점과 가장 오른쪽 점의 거리
//가장 위의 높은 점과 가장 낮은 점의 거리를 구하고,
//각 사각형의 가로 길이의 합과 세로 길이의 합과 비교하면
//어떤 상태인지 알 수 있다고 생각했다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<5; t++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //변수  초기화
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            //각 사각형의 가로 길이와 새로 길이를 구함
            int w1 = p1-x1;
            int w2 = p2-x2;
            int h1 = q1-y1;
            int h2 = q2-y2;

            //두 사각형을 동시에 놓고 가장 긴 가로와 가장 긴 세로를 구함 ( 상대 가로 & 상대 세로 말하겠음)
            int W = Math.max(Math.abs(x1-p2),Math.abs(x2-p1));
            int H = Math.max(Math.abs(y1-q2),Math.abs(y2-q1));

            // 아래는 그 비교
            //(a)
            if (W<w1+w2 && H<h1+h2)
                System.out.println("a");
            //(b)
            else if ((W<w1+w2) && (H==h1+h2))
                System.out.println("b");

            else if ((W==w1+w2) && (H<h1+h2))
                System.out.println("b");
            //(c)
            else if ((W==w1+w2)&&(H==h1+h2))
                System.out.println("c");
            //(d)
            else
                System.out.println("d");

        }
    }
}
