package z_codeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(br.readLine().trim());
            }

            Queue<String> Q = new PriorityQueue<>();
            for (int i = 0; i < M; i++) {
                String str = br.readLine().trim();
                if (set.contains(str)) {
                    Q.add(str);
                }
            }
            if (Q.size() == 0) {
                sb.append("NO!!").append('\n');
            } else {
                while (!Q.isEmpty()) {
                    String str = Q.poll();
                    sb.append(str).append(' ');
                    set.remove(str);
                }
            }
        }
        System.out.println(sb);
    }
}
