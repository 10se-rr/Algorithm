package BACKJOON.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// Baek_1080. 체스판 다시 칠하기
public class Baek_1018 {
	// [M][N] 검 흰
	// [8][8]로 잘라내서 검흰으로 칠하겠다

	// 1. 왼쪽 상단 좌표 잡기
	// 2. 칠하는 갯수 세는 메서드 만들기
	// 3. 해당 메서드에서 최솟값 업데이트
	// 4. 출력
	static char[][] arr;
	static int minCnt;
	static int M, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		minCnt = 64;

		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			arr[i] = row;

		}
		minimumPainting();
		System.out.println(minCnt);


	}

	static void minimumPainting() {
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {

				int[] countArr = new int[2]; // 0번쨰='B' 1번째='W'
				boolean check = false;
				for (int I = i; I < i + 8; I++) {
					check = !check;
					for (int J = j; J < j + 8; J++) {
						if ((check && arr[I][J] == 'B') || (!check && arr[I][J] == 'W')) {
							countArr[0]++;
						} else {
							countArr[1]++;
						}
						check = !check;
					}
				}
				int bad = Math.min(countArr[0], countArr[1]);
				minCnt = Math.min(minCnt, bad);

			}
		}
	}
}
