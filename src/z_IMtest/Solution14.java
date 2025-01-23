package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());
        int T = Integer.parseInt(br.readLine());

        int changeP =(T-(w-p))/w;
        int remainP =(T-(w-p))%w;
        int changeQ =(T-(h-q))/h;
        int remainQ =(T-(h-q))%h;

        if (changeP%2 == 1) {
            p = 0 + remainP;
        } else {
            p = w - remainP;
        }

        if (changeQ%2 == 1) {
            q = 0 + remainQ;
        } else {
            q = h -remainQ;
        }
        System.out.println(p+" "+q);
    }
}
