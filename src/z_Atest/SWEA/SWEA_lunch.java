package z_Atest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_lunch {
    static int[][] distance; // 행은 계단 인덱스 0열 row 1열 col;
    static List<Integer> pR, pC, sR, sC; // 사람 좌표, 계단 좌표
    static int[][] arr;
    static int N, numP, min;
    static List<Integer>[] time;
    static int[] K = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N][N];
            pR = new ArrayList<>();
            pC = new ArrayList<>();
            sR = new ArrayList<>();
            sC = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if (num == 1) {
                        pR.add(i);
                        pC.add(j);
                    } else if (num > 1) {
                        sR.add(i);
                        sC.add(j); // 최대 2개라는 점 기억하자.
                    }
                }
            }
            numP = pR.size();
            distance = new int[numP][2];
            getDistance();

            time = new ArrayList[2];
            for (int i = 0; i < 2; i++) {
                time[i] = new ArrayList<>();
            }
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 2; i++) {
                K[i] = arr[sR.get(i)][sC.get(i)];
            }
            dfs(0);
            sb.append(min).append('\n');
        }
        System.out.println(sb);

    }

    // 거리 배열 만드는 메서드
    static void getDistance() {
        for (int i = 0; i < numP; i++) {
            for (int j = 0; j < 2; j++) {

                distance[i][j] = Math.abs(pR.get(i) - sR.get(j)) + Math.abs(pC.get(i) - sC.get(j));
            }
        }
    }
    // dfs 메서드
    static void dfs(int depth) {

        if (depth == numP) {
            int sum = 0;
            for (int j = 0; j < 2; j++) {
                if (!(time[j].isEmpty())) {
                    time[j].sort(null);
                    measure(time[j], K[j]);
                    sum = Math.max(time[j].get(time[j].size() - 1), sum);
                }
            }
            min = Math.min(sum, min);
            return;
        }
        List<Integer> tmp0 = new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        tmp0.addAll(time[0]);
        tmp1.addAll(time[1]);
        time[0].add(distance[depth][0]);
        dfs(depth + 1);
        time[0].clear();  // 뒤에서 돌아가기 때문에 앞에서 임시 저장해서 바꿔야함.
        time[0].addAll(tmp0);
        time[1].clear();
        time[1].addAll(tmp1);
        time[1].add(distance[depth][1]);
        dfs(depth+1);
        time[0].clear();
        time[0].addAll(tmp0);
        time[1].clear();
        time[1].addAll(tmp1);
    }

    static void measure(List<Integer> list, int K) {
        if (list.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                list.set(i, list.get(i) + 1 + K);
            }
            for (int i = 3; i < list.size(); i++) {

                int a = Math.max(list.get(i-3) + K,list.get(i) + K + 1);

                list.set(i, a);
                /*if (list.get(i - 3) - K > list.get(i)) {
                    list.set(i, list.get(i - 3) + K);
                } else {
                    if (list.get(i - 3) > list.get(i) + 1) {
                        list.set(i, list.get(i - 3) + K);
                    } else {
                        list.set(i, list.get(i) + 1 + K);
                    }
                }*/
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + K + 1);
            }
        }
    }
}