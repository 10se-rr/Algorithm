package z_IMtest;

import java.util.Scanner;

public class Q1210 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        int t = 0;
        while (t<10) {
            t = sc.nextInt();

            int[][] site = new int[100][102];

            for(int i=0; i<100; i++ ) {
                for(int j=1; j<101; j++) {
                    site[i][j] = sc.nextInt();
                }
            }
            int goal = 0;
            for (int j=1; j<101; j++) {
                if (site[99][j] == 2) {
                    goal = j;
                    break;
                }
            }
            int[] dir = {-1,1};
            int row =99;
            int dc =0;

            for (int i = row; 0 <= i; i--) {
                for (int x : dir) {
                    if (site[i][goal + x] != 0) {
                        dc = x;
                        row = i;
                        while (site[row][goal + dc] != 0) {
                            goal += dc;
                        }
                        break;
                    }
                }
                row--;

            }
            System.out.println("#"+t+" "+(goal-1));
        }
    }
}

