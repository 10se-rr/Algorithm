package z_IMtest;

import java.io.*;

public class BEAK2839 {
    public static void main(String[] args) throws IOException {

        //3키로 5키로
        // 최대한 적은 봉지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int result = -1;
        for (int i = N / 5; 0 <= i; i--) {
            if (N - i * 5 >= 0)
                if ( (N - i * 5)  % 3 == 0){
                result = i + (N - i*5)/3;
                break;
            }
        }
        bw.write(result + ""); // 만족하는 정수가 없으면
        bw.flush();
        bw.close();
        br.close();
    }
}
