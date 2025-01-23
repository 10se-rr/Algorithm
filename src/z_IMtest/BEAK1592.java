package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class BEAK1592 {
    public static void main(String[] args) throws IOException {
        // 1번 부터 막 던짐
        // M번 받으면 게임 끝남.
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N번 까지 적혀있는 원형 자리
        int M = Integer.parseInt(st.nextToken());// M번 보다 작게 받은 사람이
        int L = Integer.parseInt(st.nextToken());// M이 홀수면 시계방향으로 L // 짝수면 시계반대방향으로 L

        int[] arr = new int[N];
        int i=0;
        arr[0] =1;
        int count =0;
        while (arr[i]!=M) {
            int next = (i+L)%N;
            arr[next]++;
            i= next;
            count++;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

//그냥 말 있는 그대로 풀었음
//단, 5키로 설탕 가방을 최대한 많은 양에서 하나씩 줄여나가는 방식을 취함
//그러면 가장 처음으로 매치 되는 5키로 3키로 갯수가 가장 적은 봉지 수가 됨.
