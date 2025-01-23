package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7 {
    //1순위 별
    //2순위 동그라미
    //3순위 네모
    //4순위 세모
    //5순위 무승부
    // N a b

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        out:
        for (int i = 1; i < N + 1; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int[] countA = new int[5];
            int a = Integer.parseInt(st1.nextToken());
            for (int k = 0; k < a; k++)
                countA[Integer.parseInt(st1.nextToken())]++;

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st2.nextToken());
            int[] countB = new int[5];
            for (int j = 0; j < b; j++)
                countB[Integer.parseInt(st2.nextToken())]++;


            for (int n = 4; n > 0; n--) {
                if (countA[n] > countB[n]) {
                    System.out.println("A");
                    continue out;
                } else if (countA[n] < countB[n]) {
                    System.out.println("B");
                    continue out;
                }
            }
            System.out.println("D");
        }
    }
}

// counting 배열 2개를 만들어서 비교하자는 생각을 했다.