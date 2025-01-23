package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out:
        for (int t = 1; t < 11; t++) {

            Stack<Character> stack = new Stack<>();

            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            for (int i = 0; i < len; i++) {
                char tk = str.charAt(i);
                if (tk == '{' || tk == '[' || tk == '(' || tk == '<') {
                    stack.push(tk);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("#" + t + " " + 0);
                        continue out;
                    }
                    char top = stack.pop();
                    if ((tk == '}' && top != '{') ||
                            (tk == ']' && top != '[') ||
                            (tk == ')' && top != '(') ||
                            (tk == '>' && top != '<')) {
                        System.out.println("#" + t + " " + 0);
                        continue out;
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }
}
