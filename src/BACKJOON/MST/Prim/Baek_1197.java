package BACKJOON.MST.Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Baek_1197.최소 스패닝 트리
//
// 프림으로 한 번 풀어보자
// 정점 위주로 문제를 풀어나가고 싶다는 뜻이다.
// 클래스에 나아가려는 노드의 번호와 나아가기 위한 가중치를 저장해야한다.
// 그리고 그 클래스들을 번호별로 저장할 수 있는 배열을 만들어야한다.
// 방문했는지 확인하는 배열을 만들어야 한다.
public class Baek_1197 {

    static class Edge implements Comparable<Edge> {

        int to;
        int weight;

        Edge(int num, int weight) {
            this.to = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static List<Edge>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V+1];
        //각각의 배열에 리스트를 만들어 줌.
        for (int i=1; i<=V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 각각의 정점에 간선들을 넣어줄 것
        for (int i =0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[A].add(new Edge(B,C));
            adjList[B].add(new Edge(A,C));
        }

        boolean[] visited = new boolean[V+1];

        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.add(new Edge(1, 0));
        int min = 0; // 가중치 합
        int size = 0; // 방문 정점의 갯수
        while(!Q.isEmpty() && size < V) {

            Edge curr = Q.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;

            min += curr.weight;
            size += 1;

            for (Edge nextEdge : adjList[curr.to]) {
                if(!visited[nextEdge.to]) {
                    Q.add(nextEdge);
                }
            }
        }
        System.out.println(min);
    }
}
