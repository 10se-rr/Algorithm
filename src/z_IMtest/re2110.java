package z_IMtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class re2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test=1; test<11 ; test++) {
            int t = Integer.parseInt(br.readLine().trim());

            int[][] site = new int[100][102];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < 101; j++) {
                    site[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int goal = 0;
            for (int j = 1; j < 101; j++) {
                if (site[99][j] == 2) {
                    goal = j;
                    break;
                }
            }

            int[] dir = {-1, 1};
            int row = 99;
            int dc = 0;

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

            System.out.println("#" + t + " " + (goal - 1));
        }
    }
}
