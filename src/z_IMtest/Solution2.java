package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    //1+...+9 = 45
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] puzzle = new int[9][9];

        int T = Integer.parseInt(br.readLine());
        out:
        for (int t = 1; t < T + 1; t++) {

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += puzzle[i][j];
                }
                if (sum != 45) {
                    System.out.println("#" + t + " " + (0));
                    continue out;

                }
            }
            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += puzzle[j][i];
                }
                if (sum != 45) {
                    System.out.println("#" + t + " " + (0));
                    continue out;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int sum = 0;
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            sum += puzzle[3 * i + m][3 * j + n];
                        }
                    }
                    if  (sum !=45) {
                        System.out.println("#" + t + " " + (0));
                        continue out;
                    }
                }
            }
            System.out.println("#" + t + " " + (1));
        }
    }
}

// 합은 1+2+...+9 = 45
// 줄마다 더하다가 45 안 나오면 해당 테스트 케이스 종료




