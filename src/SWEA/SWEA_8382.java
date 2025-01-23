package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA_8382. 방향전환
//
//
public class SWEA_8382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int X = Math.abs(x0 - x1);
            int Y = Math.abs(y0 - y1);

            int dif = Math.abs(X - Y);

            sb.append('#').append(t).append(' ').append(X + Y + (dif / 2) * 2).append('\n');
        }
        System.out.print(sb);
    }
}
