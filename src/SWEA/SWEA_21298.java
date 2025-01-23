package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//SWEA_21298.스코어 보드가 프리즈 되었습니다.
public class SWEA_21298 {
    static int N, A;
    static Set<String> set;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] x = new int[N + 1];
            x[1] = x1;
            x[2] = x2;

            for (int i = 3; i < N + 1; i++) {
                x[i] = (p * x[i - 1] + q * x[i - 2]) % 1000000007;
            }
            set = new HashSet<>();
            dfs(1, x);
            sb.append(set.size()).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int[] x) {

        if (depth == N + 1) {
            topologicalSort(x);
            return;
        }

        x[depth] += 1;
        dfs(depth + 1, x);
        x[depth] -= 1;

        dfs(depth + 1, x);
    }

    static void topologicalSort(int[] x) {
        int[] a = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            a[i] = a[i] % A;
        }

        int[] inDeg = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; i < N + 1; j++) {
                if (i != j && x[i] < x[j]) {
                    inDeg[j]++;
                }
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        String str = "";
        for (int i = 1; i < N + 1; i++) {
            if (inDeg[i] == 0) {
                Q.add(i);
                inDeg[i]--;
            }
        }

        while (!Q.isEmpty()) {

            int curr = Q.poll();
            str += curr;
            for (int i = 1; i < N + 1; i++) {
                --inDeg[i];
                if (inDeg[i]==0) {
                   --inDeg[i];
                   Q.add(i);
                }
            }
        }
        set.add(str);
    }
}
