package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t =1; t<T+1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            for (int i= A; i<B+1;i++) {
                list.add(i);
            }
            for (int i= A; i<B+1;i++) {
                int k = 1;
                while (i * k < B + 1) {
                    list.remove(Integer.valueOf(i * k));
                    k++;
                }
            }
            int cnt =0;
            for (int i=0 ; i<list.size(); i++) {
                List<Integer> remain = new ArrayList<>();
                int num = list.get(i);
                while (num != 0) {
                    remain.add(num % 10);
                    num = num / 10;
                }
                if (remain.contains(D))
                    cnt++;
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
// 범위가 10의 6승이라 int를 쓰기로 마음 먹음
// A 부터 B까지 숫자를 나열하고 (추가)
// A 의 배수 A+1의 배수 ... 를 지우려고함 (제거)
// 그래서 삭제 추가가 편리한 동적 자료? list를 사용하기로 결정함.
// 구현이 제대로 안 되었는지. 작동을 안 함.