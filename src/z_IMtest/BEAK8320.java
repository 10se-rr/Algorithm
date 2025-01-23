package z_IMtest;

import java.io.*;

public class BEAK8320 {
    // n개의 정사각형 만들 수 있는 직사각형의 총 몊 개?
    // n*m = 1 2 3 4 5 6 ~ 이렇게 가야한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int col = 1; col <= Math.sqrt(N); col++) {
            count += (N / col) - (col-1); // 세로 길이 기준으로 가능한 가로 갯수 - 중복(앞 전 단계)
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}