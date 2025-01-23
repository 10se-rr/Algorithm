package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class BAEK2798 {
    public static void main(String[] args) throws IOException {
        //N장의 카드
        //3장의 카드 골라야 한다.
        //M을 넘지 않으면서 가장 가깝게 만들어야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int Max =0;
        for (int i = 0; i<N-2; i++) {
            for (int j=i+1; j<N-1;j++) {
                for (int k=j+1; k<N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum <= M) {
                        Max = Math.max(Max, sum);
                    }
                }
            }
        }
        System.out.println(Max);
    }
}
// 깃발 이후로는 이런 문제에 당하지 않습니다. => 바로 전수조사
// 효울적인 전수조사를 하고 싶었습니다.
// 순서가 없고 중복이 허용되지 않는 조합 문제이기에
// N*N*N 이 아니라,
// (N*(N-1)*(N-2))/3! 번 조사하면 되기에 i=1 // j=i+1 // k = j+1 을 썼습니다.