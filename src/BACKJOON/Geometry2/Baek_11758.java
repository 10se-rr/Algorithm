package BACKJOON.Geometry2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_11758.CCW
//
// 외적 이용
public class Baek_11758 {

    static int[][] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        input = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        int dir = (input[1][0] - input[0][0]) * (input[2][1] - input[0][1]) - (input[1][1] - input[0][1]) * (input[2][0] - input[0][0]);

        if (dir > 0) {
            System.out.println(1);
        } else if (dir < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}