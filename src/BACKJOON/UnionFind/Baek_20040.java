package BACKJOON.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_20040. 사이클 게임
//
// 정확한 관계를 표시하기 위해서 pathCompression을 쓰지 않는다.
// 싸이클이 돌기 위해서는 2가지 조건이 필요하다.
// 1. 뽑은 두 점이 같은 집합 안에 있어야한다.
// 2.(오답) 이미 같은 집합 안에 있을 때, 두 점의 거리가 1이 되면 안 되기에 직접적인 부모 자식 관계여서는 안 된다.
//   (수정) 문제에서 이미 같은 선분을 고르지 않는다는 조건이 주어졌다. 집합 조건만 살피면 된다.
public class Baek_20040 {

    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N];
        makeSet(p);

        for (int i =1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 싸이클이 돌기 위한 조건
            if (findSet(A) == findSet(B)) {
                sb.append(i);
                break;
            }
            union(A,B);
        }
        //만약 끝까지 싸이클이 없다면,
        if(sb.toString().equals("")) {
            sb.append(0);
        }
        System.out.println(sb);
    }
    static void makeSet(int[] arr) {
        for(int i =0; i<arr.length; i++) {
            arr[i] = i;
        }
    }
    // (오답)
    // path Compression (X)
    // 정확한 관계를 보여야 함
    // (수정)
    // 문제에서 이미 같은 선분을 긋지 않겠다고 말했다.
    // 그렇다면 두 점이 같은 집합 안에 있기만 하면 싸이클이 도는 조건이 완성이 된다.
    static int findSet(int x) {
        if(p[x] == x) {
            return p[x];
        }
        return p[x] = findSet(p[x]);
    }

    static void union(int A, int B) {
        if (findSet(A)==findSet(B))
            return;
        p[findSet(A)] = findSet(B);
    }
}
