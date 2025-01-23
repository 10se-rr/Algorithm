package BACKJOON.BackTracking;

// 1. 0을 선택 무슨 수를 넣을지 결정 (리스트에 해당 위치 save? => 다시 돌아오기에 필요없다.)
// 2. 백트래킹 과정 ㄱㄱ
// 3. 숫자 결정 로직은?
// 4. 숫자 1~9까지 배열을 만들어서 가로 세로  격자 remove
// 5. 배열에 남아 있는 숫자로만 선택.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2580_re {
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

        for (int i = 0; i < M; i++) {
            numberTrim(zeroList.get(i));
        }
        dfs(0);
    }

    static class Zero {
        int row;
        int col;
        boolean[] visited = new boolean[9];

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

        for (int select = 0; select < 9; select++) {
            if (!currentZero.visited[select]) {
                arr[row][col] = select + 1;
                updateVisited(depth + 1);
                dfs(depth + 1);
                arr[row][col] = 0;
                resetVisited(depth + 1);
            }
        }
    }

    static void numberTrim(Zero currentZero) {
        int row = currentZero.row;
        int col = currentZero.col;

        for (int i = 0; i < 9; i++) {
            int n = arr[i][col];
            if (n != 0) currentZero.visited[n - 1] = true;
        }

        for (int j = 0; j < 9; j++) {
            int n = arr[row][j];
            if (n != 0) currentZero.visited[n - 1] = true;
        }

        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                int n = arr[i][j];
                if (n != 0) currentZero.visited[n - 1] = true;
            }
        }
    }

    static void resetVisited(int depth) {
        for (int i = depth; i < M; i++) {
            Zero currentZero = zeroList.get(i);
            for (int k = 0; k < 9; k++) {
                currentZero.visited[k] = false;
            }
            numberTrim(currentZero);
        }
    }

    static void updateVisited(int depth) {
        for (int i = depth; i < M; i++) {
            numberTrim(zeroList.get(i));
        }
    }
}