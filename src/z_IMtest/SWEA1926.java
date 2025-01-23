package z_IMtest;

import java.io.*;

public class SWEA1926 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        for (int n = 1; n< N+1; n++) {
            gameChanger(n);
        }
        bw.flush();
        bw.close();
        br.close();
    }


    static void gameChanger(int n) throws IOException {

        int count = 0;
        int tmp = n;
        while (tmp != 0) {
            if (tmp % 10 != 0 && (tmp % 10) % 3 == 0)
                count++;
            tmp = tmp / 10;
        }
        if (count == 0) {
            bw.write(String.valueOf(n));
        }
        else {
            for (int i=0; i<count; i++)
                bw.write("-");
        }
        bw.write(" ");
    }
}
