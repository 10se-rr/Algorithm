package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution22 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            Queue<Integer> Q = new PriorityQueue<>();
            while (st2.countTokens()!=0)
                Q.add(Integer.parseInt(st2.nextToken()));

            int m = 1;
            int sum = 0;
            while (N-sum != 0) {
                for (int n = M * (m - 1); n < M * m; n++) {
                }
                if (sum < K * m) {
                    m++;
                    continue;
                } else {
                    System.out.println("#" + t + " " + "Impossible");
                    break;
                }
            }
            System.out.println("#" + t + " " + "Possible");
        }
    }
}

