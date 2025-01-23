package BACKJOON.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1996 {
    // Baek_1996. 지뢰찾기

    // 델타 써야지.
    // char로 받아야하는 문제. 입력 받을 떄 O(N); 으로 받는 연습할 것
    // char를 인트로 변환하는 연습
    // char를 통해서 count

    static char[][] postMap;
    static char[][] proMap;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        postMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            postMap[i] = br.readLine().trim().toCharArray();
        }
        proMap = new char[N][N];

        makeAMap();

        for (int i=0; i<N; i++) {
            System.out.println(proMap[i]);
        }

    }

    static void makeAMap() {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( postMap[i][j] !='.') {
                    proMap[i][j] = '*';
                } else {
                    int r;
                    int c;
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        r = i + dr[d];
                        c = j + dc[d];
                        if (0<=r && r<N && 0<=c && c<N && postMap[r][c] != '.') {
                            count += postMap[r][c]-'0';
                        }
                    }
                    if ( count < 10) {
                        proMap[i][j] = (char) (count + '0');
                    } else {
                        proMap[i][j] = 'M';
                    }
                }
            }
        }
    }
}
