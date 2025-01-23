package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution12 {
    public static void main(String[] args) throws IOException {

        // a-z 0-9 ' ' < >
        // <알파벳 소문자, 공백 >
        // 연속 두 단어 공백 하나로 구분
        //태그는 단어가 아님. 태그와 단어 사이 공백 X

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        String str = "";

        char[] arr = br.readLine().toCharArray();
        String postStr = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                while (arr[i] != '>') {
                    postStr += arr[i++];
                }
                postStr += arr[i++];
            } else {
                while (i != arr.length && arr[i] != '<') {
                    stack.push(arr[i++]);
                }
                while (!stack.isEmpty()) {
                    postStr += stack.pop();
                }
            }
        }
        System.out.println(postStr);
    }
}
// String postStr = "" 만듬
// toCharArray 로 배열로 만듬.
// '<' 이것이 나온다면 '>'이 나올 때 까지 postStr에 더함
//  '<' 이것이 아니라면 '>'이 나올 떄까지 stack 에 넣음.
// 그 후에 stack.pop()을 하면서 stack이 빌 때까지 postStr에 넣음.
