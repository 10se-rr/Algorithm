package z_IMtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HM {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[100][100];

        for (int t = 1; t < 11; t++) {
            int test = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                char[] charArr = str.toCharArray();

                for (int j = 0; j < 100; j++)
                    matrix[i][j] = charArr[j];

            }
            int maxL = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 99; j++) {
                    for (int k = j + 1; k < 100; k++) {

                        if (matrix[i][j] != matrix[i][k])
                            continue;

                        else {
                            int cnt =0;
                            for (int m = 1; m < (k - j + 1) / 2; m++) {
                                if (matrix[i][j + m] == matrix[i][k - m]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                            if (cnt == ((k - j + 1) / 2)-1) {
                                int tmp = k - j + 1;
                                maxL = Math.max(maxL, tmp);
                            }
                        }

                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 99; j++) {
                    for (int k = j + 1; k < 100; k++) {

                        if (matrix[j][i] != matrix[k][i])
                            continue;

                        else {
                            int cnt =0;
                            for (int m = 1; m < (k - j + 1) / 2; m++) {
                                if (matrix[j + m][i] == matrix[k - m][i]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                            if (cnt == ((k - j + 1) / 2)-1) {
                                int tmp = k - j +1;
                                maxL = Math.max(maxL, tmp);
                            }
                        }

                    }
                }
            }
            System.out.println(maxL);
        }
    }
}