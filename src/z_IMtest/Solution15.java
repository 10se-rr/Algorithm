package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());
        int T = Integer.parseInt(br.readLine());

        int changeP =(T-(w-p))/w ;
        int remainP =(T-(w-p))%w;
        int changeQ =(T-(h-q))/h;
        int remainQ =(T-(h-q))%h;

        int x = (p + T) % (2 * w);
        int y = (q + T) % (2 * h);

        if (x > w) {
            x = 2 * w - x;
        }
        if (y > h) {
            y = 2 * h - y;
        }

        System.out.println(x + " " + y);
    }
}
