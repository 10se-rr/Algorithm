package BACKJOON.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baek_1717. 집합의 표현
//
// UnionFind 개념을 그대로 적용할 것이다.
// 하지만 조금 더 효율적으로 접근하기 위해서 Path Compression을 적용하겠다.
public class Baek_1717 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N + 1];
		
		makeSet(p);
		for (int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int method = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 합집합
			if (method == 0) {
				union(a,b);
			} else {
				if (findSet(a) == findSet(b)) {
					sb.append("YES").append('\n');
				} else { 
					sb.append("NO").append('\n');
				}
			}
		}
		System.out.println(sb);
	}
	static void makeSet(int[] arr) {
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
	}
	// pathCompression 이용
	static int findSet(int x) {
		
		if (p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}
	static void union(int a, int b) {
		
		if (findSet(a) == findSet(b)) return;
		
		p[findSet(a)] = findSet(b); // a의 최상단 노드의 부모로써 b의 최상단 노드 등록
	}
}
