package BACKJOON.BackTracking;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_15649 {

    // 자연수 N과 M이 주어졌을 때, 길이가 Md인 수열을 모두 구하는 프로그램을 작성
    // 1부터 N까지 자연수 중에서 중복없이 M개를 고른 수열 (1<= M <= N <= 8 )
    //
    //  N을 정렬하는 방법은 N에서 하나를 뽑고 N-1을 뽑는 것이다.
    //  ...
    //  결국 3에서 하나를 뽑고, 2를 정렬
    //  2에서 하나를 봅고, 1을 정렬
    // 정렬은 되어 있다고 보고 푼다.
    static int N;
    static int M;

    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            list.add(i);
        }
        getNum(list);
    }

    static void getNum (List<Integer> list) {
        for (int i=0; i<list.size(); i++) {

            System.out.print(list.get(i)+" ");
            list.remove(i);

            if (list.size() == N-M) {
                System.out.print("\n");
                continue;
            }
            getNum(list);
        }
    }
}