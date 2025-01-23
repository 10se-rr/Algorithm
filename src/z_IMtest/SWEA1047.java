package z_IMtest;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class SWEA1047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t < T + 1; t++) {

            Set<Integer> spade = new HashSet<>();
            Set<Integer> diamond = new HashSet<>();
            Set<Integer> heart = new HashSet<>();
            Set<Integer> clover = new HashSet<>();

            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {

                int cardNum =0;
                if (str.charAt(i) == 'S') {
                    cardNum += (str.charAt(i + 1)-'0') * 10;
                    cardNum += str.charAt(i + 2)-'0';
                    i += 2;
                    spade.add(cardNum);
                } else if (str.charAt(i) == 'D') {
                    cardNum += (str.charAt(i + 1)-'0') * 10;
                    cardNum += str.charAt(i + 2)-'0';
                    i += 2;
                    diamond.add(cardNum);
                } else if (str.charAt(i) == 'H') {
                    cardNum += (str.charAt(i + 1)-'0') * 10;
                    cardNum += str.charAt(i + 2)-'0';
                    i += 2;
                    heart.add(cardNum);
                } else {
                    cardNum += (str.charAt(i + 1)-'0') * 10;
                    cardNum += str.charAt(i + 2)-'0';
                    i += 2;
                    clover.add(cardNum);
                }
            }
            bw.write("#" + t);
            int spadeCnt = spade.size();
            int diamondCnt = diamond.size();
            int heartCnt = heart.size();
            int cloverCnt = clover.size();

            if (spadeCnt + diamondCnt + heartCnt + cloverCnt != str.length() / 3) {
                bw.write(" " + "ERROR"+"\n");

            } else {
                bw.write(" " + (13 - spadeCnt));
                bw.write(" " + (13 - diamondCnt));
                bw.write(" " + (13 - heartCnt));
                bw.write(" " + (13 - cloverCnt));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
