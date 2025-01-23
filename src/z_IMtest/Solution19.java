package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution19 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> Q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                Q.add(Integer.parseInt(st.nextToken()));
            }

            Stack<Integer> stack = new Stack<>();

            int max = 0;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                int tmp = Q.poll();

                if (i!=N-1 && tmp <= Q.peek())
                    stack.push(tmp);
                else {
                    if (max < tmp) {
                        sum += (tmp - max) * (i - stack.size());
                        max = tmp;
                    }
                    while(!stack.isEmpty())
                        sum += tmp - stack.pop();
                }
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}