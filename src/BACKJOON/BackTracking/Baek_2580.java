

// 1. 0을 선택 무슨 수를 넣을지 결정 (리스트에 해당 위치 save? => 다시 돌아오기에 필요없다.)
// 2. 백트래킹 과정 ㄱㄱ
// 3. 숫자 결정 로직은?
// 4. 숫자 1~9까지 배열을 만들어서 가로 세로  격자 remove
// 5. 배열에 남아 있는 숫자로만 선택.

package BACKJOON.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2580 {

    static int[][] arr = new int[9][9];
    static List<Zero> zeroList = new ArrayList<>();
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    Zero currentZero = new Zero(i, j);
                    zeroList.add(currentZero);
                }
            }
        }
        M = zeroList.size();
        dfs(0);
    }
    static class Zero {
        int row;
        int col;

        Zero(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        Zero currentZero = zeroList.get(depth);
        int row = currentZero.row;
        int col = currentZero.col;

        boolean[] visited = new boolean[9];
        numberTrim(row, col, visited);

        for (int select = 0; select < 9; select++) {
            if (!visited[select]) {
                arr[row][col] = select + 1;
                dfs(depth + 1);
                arr[row][col] = 0;
            }
        }
    }

    static void numberTrim(int row, int col, boolean[] visited) {

        for (int i = 0; i < 9; i++) {
            int n = arr[i][col];
            if (n != 0)
                visited[n - 1] = true;
        }

        for (int j = 0; j < 9; j++) {
            int n = arr[row][j];
            if (n != 0) visited[n - 1] = true;
        }

        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (arr[i][j] != 0) {
                    visited[arr[i][j] - 1] = true;
                }
            }
        }
    }
}