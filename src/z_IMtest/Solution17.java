package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17 {
    //      4
    //  2       1
    //      3
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dirBox = new int[6];
        int[] lengthBox = new int[6];

        for (int i= 0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirBox[i] = Integer.parseInt(st.nextToken());
            lengthBox[i] = Integer.parseInt(st.nextToken());
        }
        int x = 0;
        while (true) {

            if ((dirBox[x % 6] == dirBox[(x + 2) % 6]) && (dirBox[(x + 1) % 6] == dirBox[(x + 3) % 6])) {
                break;
            } else
                x++;
        }
        // (x+3)%6  (x+4)%6  (x+1)%6 (x+2)%6

        int size = lengthBox[(x+4)%6]*lengthBox[(x+5)%6] - lengthBox[(x+1)%6]*lengthBox[(x+2)%6];

        System.out.println(N*size);
    }
}
// 큰 직사각형 - 작은 직사각형 하려고 맘 먹음
// 무엇이 큰직 사각형의 가로 세로 길이인지, 무엇이 작은 직사각형의 가로 세로 길이인지 구해야했음
// 방향은 dirBox[] 에 모으고,
// 길이는 lengthBox[] 에 모았음.
// 방향에서 꺽이는 부분(작은 사각형이 만들어 지는 부분)은 1313 이런식으로 반복 된다는 사실을 기반으로
// 반복되는 부분의 2번째 3번째 를 곱하면 작은 사각형임.
// 그리고 반복되는 부분에서 +3 +4 인덱스를 곱하면 큰 사각형임.
// 그걸 식으로 옮김.
