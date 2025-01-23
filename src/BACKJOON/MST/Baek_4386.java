package BACKJOON.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baek_4386.별자리 만들기
//
// MST
// 가중치 => 거리 만큼 들구나
// 모든 별이 간선을 가지기에
// 프림 알고리즘으로 정점 위주로 계산을 해야한다고 생각한다.

public class Baek_4386 {

    static class Star implements Comparable<Star> {

        int num;
        double dis;

        public Star(int num, double dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.dis, o.dis);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        double[][] star = new double[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            star[i][0] = Double.parseDouble(st.nextToken());
            star[i][1] = Double.parseDouble(st.nextToken());
        }

        List<Star>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dis = distance(star[i][0], star[i][1], star[j][0], star[j][1]);
                adjList[i].add(new Star(j, dis));
                adjList[j].add(new Star(i, dis));
            }
        }
        boolean[] visited = new boolean[N];

        PriorityQueue<Star> Q = new PriorityQueue<>();

        Q.add(new Star(0, 0));

        int size = 0;
        double sum = 0;
        while (!Q.isEmpty() && size < N) {

            Star curr = Q.poll();

            if (visited[curr.num]) continue;

            visited[curr.num] = true;
            sum += curr.dis;
            size += 1;
            for (Star next : adjList[curr.num]) {
                if (!visited[next.num]) {
                    Q.add(next);
                }
            }
        }
        sum = Math.round(sum*100) / 100.0;
        System.out.println(sum);
    }

    public static double distance(double x, double y, double X, double Y) {

        double result = Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - Y, 2));

        return result;
    }
}
