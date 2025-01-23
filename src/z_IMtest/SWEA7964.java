package z_IMtest;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA7964 {
    // D 이하 끼리 차원 이동 가능
    // 차원관문 최소개수 구하기
    // 이동에 필요한 차원관문의 최소 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t =1; t< T+1; t++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int D = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int count = 0;
            boolean[] arr = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (st2.nextToken().equals("1")) {
                    arr[i] = true;
                }
            }
            if (!arr[0]) {
                arr[0] = true;
                count++;
            }
            if (!arr[N-1]) {
                arr[N-1] = true;
                count++;
            }


            out:
            for (int i = 0; i < N; i++) {
                for (int d = 1; d <= D; d++) {
                    if (i + d < N && !arr[i + d]) {
                        if (d!=D) {
                            continue;
                        } else {
                            arr[i + D] = true;
                            count++;
                        }
                    } else {
                        i = i + d - 1;
                        continue out;
                    }
                }
            }
            bw.write("#" + t + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

//문제가 이상함