package z_IMtest;

import java.io.*;

public class SWEA7087 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        out:
        for (int t = 1; t<T+1; t++) {

            boolean[] arr = new boolean[26];
            int N = Integer.parseInt(br.readLine());
            for (int n =0; n<N; n++) {
                String str = br.readLine();
                arr[str.charAt(0)-'A'] = true;
            }
            for (int n =0; n<26; n++) {
                if (!arr[n]) {
                    bw.write("#"+ t + " " + n + "\n");
                    continue out;
                }
                if (n==25)
                    bw.write("#"+ t + " " + 26 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 모든 책의 첫 글자를 보고, arr를 true 로 바꿔준다.
// 해당 arr에서 처음 false 가 나오면
// 해당 인덱스가 쓸 수 있는 책의 갯수