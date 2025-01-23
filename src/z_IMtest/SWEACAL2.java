package z_IMtest;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEACAL2 {
    static String[][] arr;
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new String[N + 1][4]; // 0열 데이터, 1열 자손, 2열 자손

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                arr[index][0] = st.nextToken();
                if (st.hasMoreTokens()) arr[index][1] = st.nextToken();
                if (st.hasMoreTokens()) arr[index][2] = st.nextToken();
            }

            postOrder(1);

            bw.write("#" + t + " " + stack.pop() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void postOrder(int root) {
        if (root >= arr.length || arr[root][0] == null) {
            return;
        }

        if (arr[root][1] != null) {
            postOrder(Integer.parseInt(arr[root][1]));
        }
        if (arr[root][2] != null) {
            postOrder(Integer.parseInt(arr[root][2]));
        }

        String data = arr[root][0];
        if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());
            if (arr[root][0].equals("+")) {
                arr[root][0] = String.valueOf(num1 + num2);
                stack.push(arr[root][0]);
            } else if (arr[root][0].equals("-")) {
                arr[root][0] = String.valueOf(num1 - num2);
                stack.push(arr[root][0]);
            } else if (arr[root][0].equals("*")) {
                arr[root][0] = String.valueOf(num1 * num2);
                stack.push(arr[root][0]);
            } else {
                arr[root][0] = String.valueOf(num1 / num2);
                stack.push(arr[root][0]);
            }
        } else {
            stack.push(data);
        }
    }
}
