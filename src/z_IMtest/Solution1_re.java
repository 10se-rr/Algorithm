package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] magnetic = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    magnetic[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int finalTotal = 0;

            for (int j = 0; j < N; j++) {
                boolean hasNorth = false;
                int total = 0;
                for (int i = 0; i < N; i++) {
                    if (magnetic[i][j] == 1) {
                        hasNorth = true;
                    } else if (magnetic[i][j] == 2) {
                        if (hasNorth) {
                            total++;
                            hasNorth = false;
                        }
                    }
                }
                finalTotal += total;
            }

            System.out.println("#" + t + " " + finalTotal);
        }
    }
}