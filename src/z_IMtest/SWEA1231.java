package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1231 {
    static  String[] tree;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            tree = new String[N + 1];
            for (int n = 1; n < N + 1; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[n] = st.nextToken();
            }
            bw.write("#"+t+" ");
            inorder(1);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void inorder(int root) throws IOException{
    if (root >= tree.length || tree[root] == null) {
        return;
    }
    inorder(root*2);
    bw.write(tree[root]);
    inorder(root*2+1);
    }
}