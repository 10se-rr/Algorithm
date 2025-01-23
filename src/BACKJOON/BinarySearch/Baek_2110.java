package BACKJOON.BinarySearch;

// Baek_2110. 공유기 설치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 같은 좌표는 없다!
// 공유기 C개를 설치 계획
// 한 집에 공유기 1개만 설치할 수 있고,
// 가장 인접한 두 공유기 사이의 거리를 가능한 최대로...
// 2<= N <= 200,000 집의 개수
// 2<= C <=N 공유기의 개수
// 0<= x <=1,000,000,000 ( 10억 <= 21억4000만)

public class Baek_2110 {
    static int N,C;
    static int[] house;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); //정렬 해야함






    }
}
