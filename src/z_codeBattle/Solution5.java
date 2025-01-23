package z_codeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution5 {

    static class Node implements Comparable<Node> {
        int idx;        // 노드의 인덱스
        int distance;  // 현재까지의 거리

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
        // 거리 기준으로 오름차순 정렬
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 각 테스트케이스 반복
        for (int t = 1; t <= T; t++) {
            // 길의 개수
            int N = Integer.parseInt(br.readLine());

            // 그래프 초기화
            int[][] graph = new int[52][52];
            for (int i = 0; i < 52; i++) {
                Arrays.fill(graph[i], -1); // 초기 비용 -1 (연결 없음 표시)
            }

            // N개의 길 초기화
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char startChar = st.nextToken().charAt(0);
                char endChar = st.nextToken().charAt(0);
                int cost = Integer.parseInt(st.nextToken());

                int start = charToIndex(startChar);
                int end = charToIndex(endChar);

                // 임스
                graph[start][end] = cost;
                // 반싸피
                graph[end][start] = cost;
            }

            // 임스는 'a'에서 'Z'로 이동
            int startIms = charToIndex('a');
            int endIms = charToIndex('Z');

            // 반싸피는 'Z'에서 'a'로 이동
            int startBanssafy = endIms;
            int endBanssafy = startIms;

            // 임스의 최단 시간
            int timeIms = dijkstra(startIms, endIms, graph);

            // 반싸피의 최단 시간
            int timeBanssafy = dijkstra(startBanssafy, endBanssafy, graph);

            sb.append('#').append(t).append(' ');
            if (timeIms == Integer.MAX_VALUE) {
                // 임스가 목적지에 도달할 수 없는 경우
                sb.append("NO\n");
            } else {
                if (timeBanssafy == Integer.MAX_VALUE || timeIms <= timeBanssafy) {
                    // 반싸피가 목적지에 도달할 수 없거나, 임스가 먼저 또는 동시에 도착할 수 있는 경우
                    sb.append("YES ").append(timeIms).append('\n');
                } else {
                    // 임스가 반싸피보다 늦게 도착하는 경우
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }

    private static int charToIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return 26 + (c - 'A');
        }

    }

    private static int dijkstra(int start, int end, int[][] graph) {
        // 최단 거리 배열 초기화
        int[] dist = new int[52];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐에 위의 데이터를 받아서 인스턴스 넣음
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.idx;
            int currentDist = current.distance;

            // 끝난 노드는 건너뜀
            if (currentDist > dist[u]) {
                continue;
            }

            // 인접 노드 탐색
            for (int v = 0; v < 52; v++) {
                if (graph[u][v] != -1) { // 연결된 노드인 경우
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new Node(v, newDist));
                    }
                }
            }
        }
        return dist[end];
    }
}
