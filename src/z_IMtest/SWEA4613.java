package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flag = new int[N][3]; // 'W'==0 'B'==1 'R'==2 으로 넣겠음.

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (str.charAt(j) == 'W')
                        flag[i][0]++;
                    else if (str.charAt(j) == 'B')
                        flag[i][1]++;
                    else
                        flag[i][2]++;
                }
            }
            int min = M * N;
            // 2개의 경계선을 정해서 일일히 비교하겠음.
            for (int l1 = 0; l1 <= N - 3; l1++) {
                for (int l2 = l1 + 1; l2 <= N-2; l2++) {
                    int sum = 0;

                    for (int i = 0; i <= l1; i++) {
                        sum += M - flag[i][0];
                    }
                    for (int i = l1+1; i <= l2; i++) {
                        sum += M - flag[i][1];
                    }
                    for (int i = l2 + 1; i <= N-1; i++) {
                        sum += M - flag[i][2];
                    }
                    min = Math.min(sum, min);
                }
            }
            System.out.println("#"+t+" "+min);
        }
    }
}
