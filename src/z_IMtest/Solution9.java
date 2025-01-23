package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9 {

    // 색종이 수 N
    // 가로 1001칸 세로 1001칸
    // 가장 왼쪽 아래 좌표  +  가로 + 높이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] site = new int[1001][1001];

        int[] count = new int[N+1];

        for (int n= 0; n< N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = 0; i<r;i++) {
                for (int j=0; j<c;j++) {
                    site[x+i][y+j] = n+1;
                }
            }
        }
        for (int i = 0; i<1001;i++) {
            for (int j = 0; j < 1001; j++) {
                count[site[i][j]]++;
            }
        }
        for (int m =0; m<N; m++) {
            System.out.println(count[m+1]);
        }
    }
}

// 첫 색종이로 1을 채우고
// 두 번째 색종이로 2를 채우고 ...
// n 번째 색종이로 n을 채움
// 마지막에 숫자를 counting 하는 배열을 만들고
// 카운팅 한 것들 출력함.