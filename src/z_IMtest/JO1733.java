package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1733 {
    // 검은색1 흰색2 비김 0
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] dr = {1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1};

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                int color = board[i][j];
                if (color != 0) {// 시작돌 색
                    out:
                    for (int n = 0; n < 4; n++) {
                        if (0 > i - dr[n] || i - dr[n]>18 || 0 > j - dc[n] || board[i - dr[n]][j - dc[n]] != color) {

                            int m = 1;
                            while (m < 5) {
                                if (j + dc[n] * m< 19 && i + dr[n] * m < 19 && 0 <= i + dr[n] * m && board[i + dr[n] * m][j + dc[n] * m] == color) {
                                    m++;
                                } else {
                                    continue out;
                                }
                            }
                            if (m == 5) {
                                if (i + dr[n] * 5 == 19 || i + dr[n] * 5 == -1 || j + dc[n] * 5 == 19 || board[i + dr[n] * 5][j + dc[n] * 5] != color) {
                                    System.out.println(color);
                                    System.out.println((i + 1) + " " + (j + 1));
                                    System.exit(0);
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}


