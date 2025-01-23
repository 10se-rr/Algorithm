package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Baekjoon 2263. 트리의 순회


public class Baek_2263 {
    static int[] inOrder;
    static int[] postOrder;
    static StringBuilder sb;
    static HashMap<Integer, Integer> inOrderMap;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        StringTokenizer st2;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        inOrder = new int[N];
        postOrder = new int[N];
        inOrderMap = new HashMap<>();

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
            inOrderMap.put(inOrder[i], i);
        }
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }


        buildPreOrder(0, N - 1, 0, N - 1);
        System.out.println(sb);
    }


    static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder[postEnd];
        sb.append(root).append(' ');

        int rootIdx = inOrderMap.get(root);


        int leftSize = rootIdx - inStart;


        buildPreOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);


        buildPreOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
