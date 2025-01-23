package z_IMtest;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEACAL {
    static String[][] arr;
    static int num1;
    static int num2;
    static String sign;
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t < 11; t++) {

            int N = Integer.parseInt(br.readLine());
            arr = new String[N + 1][3];//0열 데이터 1열 자손 2열 자손

            for (int i = 1; i < N + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                int col = 0;
                while (st.countTokens() != 0) {
                    arr[i][col] = st.nextToken();
                    col++;
                }

            }
            postOrder(1);

            bw.write("#" + t + " " + arr[1][0] + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void postOrder(int root) {
        if (root >= arr.length || arr[root][1] == null || arr[root][2] == null)
            return;

        postOrder(2 * root);
        postOrder(2 * root + 1);
        if (!arr[root][0].equals("+") && !arr[root][0].equals("-") || !arr[root][0].equals("*") || !arr[root][0].equals("/")) {
            stack.add(arr[root][0]);
        } else {
            if (arr[root][0].equals("+")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                arr[root][0] = String.valueOf(num1 + num2);
                stack.add(arr[root][0]);
            } else if (arr[root][0].equals("-")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                arr[root][0] = String.valueOf(num1 - num2);
            } else if (arr[root][0].equals("*")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                arr[root][0] = String.valueOf(num1 * num2);
                stack.add(arr[root][0]);
            } else {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                arr[root][0] = String.valueOf(num1 / num2);
                stack.add(arr[root][0]);
            }
        }
    }
}
