package z_IMtest;

import java.io.*;

public class SWEA14555 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            String str = br.readLine();
            int sum = 0;
            for (int i = 0; i < str.length()-1; i++) {
                if (str.charAt(i) == '(' && str.charAt(i + 1) == '|') {
                    sum++;
                } else if (str.charAt(i) == '|' && str.charAt(i + 1) == ')') {
                    sum++;
                } else if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
                    sum++;
                }
            }
            bw.write("#" + t + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

//      ...()..()()...().
//      |..(|.||)||||.().