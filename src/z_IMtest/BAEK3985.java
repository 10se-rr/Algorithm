package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class BAEK3985 {
    //나는 짜파게티 요리사
    // 길이 L
    // 방청객 N
    // 1미터 단위로 자름
    // 왼쪽부터 1234
    // P~K
    //
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[L];
        int expectedMax = 0;
        int expectedNum =0;
        int actualMax = 0;
        int actualNum = 0;

        for (int num=0; num<N; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (expectedMax < K - P) {
                expectedNum = num+1;
                expectedMax = K - P;
            }
            int count =0;
            for (int i= P-1; i<K; i++) {
                if (!arr[i]) {
                    arr[i] = true;
                    count++;
                }
            }
            if(actualMax < count ) {
                actualMax = count;
                actualNum = num+1;
            }
        }
        bw.write(expectedNum+"\n"+actualNum);
        bw.flush();
        bw.close();
        br.close();
    }
}
