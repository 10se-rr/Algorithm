package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution13 {
    public static void main(String[] args) throws IOException {
        //가로 w 세로 h
        //(p,q) 개미 한 마리
        //오른쪽 45도로 움직임
        //반사 되어 움직임

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());
        int T = Integer.parseInt(br.readLine());

        int dp = 1;
        int dq = 1;
        int P =p;
        int Q =q;

        for (int t = 1; t<T+1; t++) {
            P = p + dp;
            Q = q + dq;

            if (P == w || P == 0) {
                dp *= -1;
            }
            if (Q == h || Q == 0) {
                dq *= -1;
            }
            p = P;
            q = Q;
        }

        System.out.println(P+" "+Q);








    }
}
