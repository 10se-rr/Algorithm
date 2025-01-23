package z_IMtest;

import java.io.*;

public class SWEA4789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t= 1; t<T+1; t++) {
            String clap = br.readLine();

            int need = 0;
            int count = 0;

            for (int i =0; i< clap.length();i++) {

                if (count >= i) {
                    count += clap.charAt(i)-'0';
                }
                else {
                    int num = i - count;
                    need += num;
                    count += num + clap.charAt(i)-'0';
                }
            }
            bw.write("#"+t+" "+need+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
