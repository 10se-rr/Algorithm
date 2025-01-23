package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BEAK2999 {
    //정인의 메시지는 총 N글자
    //R<=C && R*C =N
    // 그러한 경우가 여러개 라면 그 중R이 가장 큰 것을 고른다.
    //그 다음 행이 R개이고 열이 C개인 행렬을 만든다.
    //그리고 행렬은 행방향으로 한 칸씩 채움
    //

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();

        int R = 0;
        int C = 0;
        for (int i = code.length(); 1 <= i; i--) {
            if ((code.length()) % i == 0 && i <= ((code.length()) / i)) {
                C = i;
                R = (code.length()) / i; // => 질문 !! 원래 R과 C를 반대로 적었음. 근데 왜인지는 모르겠는데, 반대여야 답이 나옴.
                break;
            }
        }

        char[][] codeArr = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                codeArr[i][j] = code.charAt(C * i + j);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                sb.append(codeArr[i][j]);
            }
        }

        String letter = sb.toString();

        System.out.println(letter);

    }
}
// 문제 있는 그대로 풀었습니다.
