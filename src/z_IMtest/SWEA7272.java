package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA7272 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        out:
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (str1.length() != str2.length()) {
                bw.write("#" + t + " " + "DIFF" + "\n");
                continue out;
            }

            for (int i = 0; i < str1.length(); i++) {
                if (noGlass(str1, i) != noGlass(str2, i)) {
                    bw.write("#" + t + " " + "DIFF" + "\n");
                    continue out;
                }
            }
            bw.write("#" + t + " " + "SAME" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    static int noGlass(String str, int i) {

        if (str.charAt(i) == 'A' || str.charAt(i) == 'D' || str.charAt(i) == 'O' || str.charAt(i) == 'P' || str.charAt(i) == 'Q' || str.charAt(i) == 'R')
            return 1;

        else if (str.charAt(i) == 'B')
            return 2;

        else
            return 0;

    }
}

