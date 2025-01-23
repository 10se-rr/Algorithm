package BACKJOON.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Baek_4195. 친구 네트워크

// 친구관계가 어떻게 되는지는 상관 없다.
// 나는 그 관계 집합 안에 총 몇명이 들어 있는지만 궁금하다
// 해쉬 맵으로 표현 해야하나...?

//(수정)
//랭크로 표현할 방법이 있을까?
public class Baek_4195re {
    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            parent = new HashMap<>();
            size = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();
                // make set 하는 곳
                if (!parent.containsKey(A)) {
                    parent.put(A, A);
                    size.put(A, 1);
                }
                if (!parent.containsKey(B)) {
                    parent.put(B, B);
                    size.put(B,1);
                }
                union(A, B);

                sb.append(size.get(findSet(A))).append('\n');
            }
//            for (String key : parent.keySet()) {
//                System.out.println(key + " "+ parent.get(key) + "\n");
//            }
        }
        System.out.println(sb);
    }

    // path Compression
    static String findSet(String name) {
        if (name.equals(parent.get(name)))
            return name;
        parent.replace(name, findSet(parent.get(name)));
        return parent.get(name);
    }

    static void union(String A, String B) {
        if (findSet(A).equals(findSet(B))) {
            return;
        }
        size.replace(findSet(B),size.get(findSet(A))+size.get(findSet(B)));
        parent.replace(findSet(A),findSet(B));
    }
}
