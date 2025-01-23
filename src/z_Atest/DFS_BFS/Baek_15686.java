package z_Atest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_15686 {
    static int[][] metric;
    static List<Integer> chickenR,chickenC,homeR,homeC;
    static int[][] distance;
    static int[] minChicken;
    static int N,M,min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int num;
        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0;j<M; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homeR.add(i);
                    homeC.add(j);
                } else if (num == 2) {
                    chickenR.add(i);
                    chickenC.add(j);
                }
            }
        }
        int chicken = chickenC.size();
        int home = homeC.size();
        distance = new int[chicken][home];
        for (int i = 0; i<chicken; i++) {
            for (int j = 0; j < home; j++) {
                distance[i][j] = Math.abs(chickenC.get(i)-homeC.get(j)) + Math.abs(chickenR.get(i)-homeR.get(j));
            }
        }
        min = Integer.MAX_VALUE;
        minChicken = new int[N];
        for (int i=0; i<N;i++) {
            minChicken[i] = Integer.MAX_VALUE;
        }
        func(0,0);

    }

    static void func(int depth,int start) {

        if (depth == M) {
            int sum =0;
            for (int i=0; i<N;i++) {
                sum += minChicken[i];
            }
            min = Math.min(min,sum);
            return;
        }

        for (int i = 0; i<chickenC.size(); i++) {
            for(int j=0; j<N; j++) {
                minChicken[i] = Math.min(minChicken[i], distance[i][j]);
            }
        }






    }
}
