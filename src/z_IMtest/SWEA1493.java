package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1493 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            bw. write ("#" + t + " " + add(X, Y) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    static int add(int X, int Y) {

        StringTokenizer coor1 = new StringTokenizer(changeToCoor(X));
        StringTokenizer coor2 = new StringTokenizer(changeToCoor(Y));
        int x = Integer.parseInt(coor1.nextToken());
        int y = Integer.parseInt(coor1.nextToken());
        int w = Integer.parseInt(coor2.nextToken());
        int z = Integer.parseInt(coor2.nextToken());

        return coorToNum(x+w, y+z);
    }

    static String changeToCoor(int number) {
        int p = 1; // 줄 선택;
        int n = 1;
        while (p <= number) {
            p += n;
            n++;
        }
        int Xaxis = n - (p - number);
        int Yaxis = p - number;

        String coor = Xaxis + " " + Yaxis;

        return coor;
    }

    static int coorToNum(int x, int y) {

        int n = (x+y-1); // 몇 번째 줄;

        int num = 1+ ((n-1)*n)/2 + (x-1);

        return num;
    }

}
