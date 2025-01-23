package BACKJOON.Geometry2;

//Baek_2166. 다각형의 면적
//
// N개(3<=N<=10000)개의 점으로 이루어진 다각형
// 넓이를 구하라
// 좌표값은 100,000을 넘가지 않는다.
// 다각형이 이루는 순서대로 값을 주었다.
// 그럼 삼각형으로 나누어서 문제를 풀면 되겠다!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2166 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long x0 = Long.parseLong(st.nextToken());
        long y0 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2;
        long y2;

        long sum = 0;
        for (int i =2; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            x2 = Long.parseLong(st.nextToken());
            y2 = Long.parseLong(st.nextToken());

            sum += (x0*y1 + x1*y2 + x2*y0) - (x1*y0 + x2*y1 + x0*y2);

            x1 = x2;
            y1 = y2;
        }

        String result = String.format("%.1f",Math.abs(sum)/2.0);
        System.out.println(result);
    }
}
