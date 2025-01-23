package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1248 {
    static int[][] arr;
    static int count;
    static int countSub;
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr = new int[V + 1][4];
            // 0열 부모 => 자식 (1)
            // 1열 부모 => 자식 (2)
            // 자식수
            // 3열 자식 => 부모
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            while (st.countTokens() != 0) {
                int parent = Integer.parseInt(st2.nextToken());
                int child = Integer.parseInt(st2.nextToken());
                if (arr[parent][0] != 0)
                    arr[parent][0] = child;
                else
                    arr[parent][1] = child;
                arr[parent][2]++;
                arr[child][3] = parent;
            }
            int max = Math.max(A, B);
            int ans = 0;
            int root =A;
            while (1<=root) {
                count = 0;
                postorder(root);
                if (count == 2) {
                    ans = root;
                    bw.write("#" + t + " " + ans + " ");
                    break;
                }
                root = arr[root][3];
            }
            countSub = 0;
            postorderCount(ans);
            bw.write(countSub + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void postorder(int root) {

        if (arr[root][0] != 0) postorder(arr[root][0]);
        if (root == A || root == B) count++;
        if (arr[root][1] != 0) postorder(arr[root][1]);
    }

    static void postorderCount(int root) {
        if (root > arr.length - 1)
            return;
        if (arr[root][0] != 0) postorder(arr[root][0]);
        countSub++;
        if (arr[root][1] != 0) postorder(arr[root][1]);
    }
}
