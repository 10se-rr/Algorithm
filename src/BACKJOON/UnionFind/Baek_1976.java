package BACKJOON.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Baek_1976. 여행가자
//
// 결국 연결만 되어있으면 된다는 말이다.
// 따라서 유니온 파인드를 이용하여 풀겠다.
public class Baek_1976 {
	static int[] p;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		p = new int[N + 1];
		makeSet(p);

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int linked = Integer.parseInt(st.nextToken());

				if (linked == 1) {
					union(i, j);
				}
			}
		}
		boolean flag = false;
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M - 1; i++) {
			if (findSet(arr[i]) != findSet(arr[i + 1])) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

	static void makeSet(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	static int findSet(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}

	static void union(int a, int b) {

		if (findSet(a) == findSet(b)) {
			return;
		} else {
			p[findSet(a)] = findSet(b);
		}
	}
}
