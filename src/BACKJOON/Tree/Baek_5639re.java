package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baek_5639. 이진 검색 트리 (경로 압축 버전)
//
// 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키 보다 작다.
// 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키 보다 크다.
// 입력으로 전위 순회가 나온다.
// 첫 노드 보다 큰 숫자가 나오는 순간에 오른쪽 자식으로 바뀜
// 반복 행위이기 때문에 재귀로 접근해야 함.
public class Baek_5639re {

    static class Node {
        int num;
        Node left;
        Node right;


        Node(int num) {
            this.num = num;
        }
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input = br.readLine();

        while (input != null && !input.isEmpty()) {
            int inputNum = Integer.parseInt(input);

            addNode(root, new Node(inputNum));

            input = br.readLine();
        }
        postOrder(root);
        System.out.println(sb);
    }

    static void postOrder(Node node) {

        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);

        sb.append(node.num).append('\n');
    }

    static public void addNode(Node curr, Node newNode) {

        if (curr.num > newNode.num) {
            if (curr.left == null) {
                curr.left = newNode;
            } else {
                addNode(curr.left, newNode);
            }
        } else if (curr.num < newNode.num) {
            if (curr.right == null) {
                curr.right = newNode;
            } else {
                addNode(curr.right, newNode);
            }
        }
    }

}
