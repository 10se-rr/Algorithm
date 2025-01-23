package BACKJOON.topologicalSort;

// Baek_2252. 줄세우기
//
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_2252 {
    static class Node{
        int num;
        List<Node> adjList = new ArrayList<>();
        int inDeg = 0;

        Node(int num) {
            this.num =num;

        }
    }
    static Node[] nodes;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new Node[N+1];
        for (int i=1; i<N+1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i=0;i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A].adjList.add(nodes[B]);
            nodes[B].inDeg++;
        }



    }
    static void topologicalSort(Node[] nodes) {

        Queue<Node> Q = new LinkedList<>();

        for (int i=1; i<N+1; i++) {

            if (nodes[i].inDeg ==0) {
                Q.add(nodes[i]);
                nodes[i].inDeg--; // 다시는 선택을 안 하기 위함임.
            }
        }

        while (!Q.isEmpty()) {

            Node curr = Q.poll();


            for (Node next : curr.adjList) {
                next.inDeg--;
                if (next.inDeg == 0) {
                    Q.add(next);
                    next.inDeg--; // 다시는 선택을 안 하기 위함.
                }
            }
        }
    }
}
