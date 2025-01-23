package BACKJOON.DP;

// Baek_11054. 가장 긴 바이토닉 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine().trim());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 부분 수열(LIS) 계산
        int[] dp1 = new int[N];
        for(int i=0; i<N; i++) {
            dp1[i] = 1; // 각 위치에서 최소 길이는 1
            for(int j=0; j<i; j++) {
                if(seq[j] < seq[i] && dp1[i] < dp1[j] + 1){
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        // 감소 부분 수열(LDS) 계산
        int[] dp2 = new int[N];
        for(int i=N-1; i>=0; i--){
            dp2[i] = 1; // 각 위치에서 최소 길이는 1
            for(int j=N-1; j>i; j--){
                if(seq[j] < seq[i] && dp2[i] < dp2[j] + 1){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        // 바이토닉 부분 수열의 최대 길이 계산
        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }

        System.out.println(ans);
    }
}
