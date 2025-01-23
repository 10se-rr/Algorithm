package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7236 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        for (int t = 1; t < T + 1; t++) {

            int N = Integer.parseInt(br.readLine());

            String[][] site = new String[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    site[i][j] = st.nextToken();
                }
            }
            int MAX = 0;
            int I;
            int J;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum=0;
                    for (int d=0; d<8; d++) {
                        I = i +dr[d];
                        J = j +dc[d];
                        if (-1 < I && I<N && -1 <J && J<N && site[I][J].equals("W")) {
                            sum++;
                        }
                    }
                    if (sum==0) {
                        sum = 1;
                    }
                    MAX = Math.max(MAX,sum);
                }
            }
            System.out.println("#"+t+" "+MAX);
        }
    }
}