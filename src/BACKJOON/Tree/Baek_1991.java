package BACKJOON.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_1991. 트리의 순회
//
// 전위순회
// 중위순회
// 후위순회
// 일단 노드의 대표 번호가 숫자가 아니라서,
// 클래스 객체 안에 표시해야한다.
public class Baek_1991 {

    static class Node {

        char name;
        Node leftChild;
        Node rightChild;

        Node() {};

        Node(char name, Node leftChild, Node rightChild) {
            this.name = name;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    static Node[] nodes;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        init();

        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            makeNode(str.charAt(0), str.charAt(2), str.charAt(4));
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');

        System.out.println(sb);

    }

    static void init() {
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }
    }

    static void makeNode(char name, char left, char right) {

        nodes[name - 'A'].name = name;

        if (!String.valueOf(left).equals(".")) {
            nodes[name - 'A'].leftChild = nodes[left - 'A'];
        }
        if (!String.valueOf(right).equals(".")) {
            nodes[name - 'A'].rightChild = nodes[right - 'A'];
        }
    }


    static void preOrder(int N) {

        sb.append(nodes[N].name);

        if(nodes[N].leftChild != null) {
            preOrder(nodes[N].leftChild.name - 'A');
        }
        if(nodes[N].rightChild != null) {
            preOrder(nodes[N].rightChild.name - 'A');
        }
    }

    static void inOrder(int N){
        if(nodes[N].leftChild != null) {
            inOrder(nodes[N].leftChild.name - 'A');
        }
        sb.append(nodes[N].name);

        if(nodes[N].rightChild != null) {
            inOrder(nodes[N].rightChild.name - 'A');
        }
    }
    static void postOrder(int N){
        if(nodes[N].leftChild != null) {
            postOrder(nodes[N].leftChild.name - 'A');
        }
        if(nodes[N].rightChild != null) {
            postOrder(nodes[N].rightChild.name - 'A');
        }
        sb.append(nodes[N].name);
    }
}
