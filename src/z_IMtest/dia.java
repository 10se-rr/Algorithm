package z_IMtest;

public class dia {
    public static void main(String[] args) {
        int num=1;
        for(int i = 3 ; i>-4 ; i--) {
            //빈 공간
            for (int j = 0; j < Math.abs(i); j++) {
                System.out.print("    ");
            }
            //숫자 공간
            for (int k = 0; k < (4 - Math.abs(i))*2-1; k++) {
                System.out.printf("%-4d", num);
                num++;
            }
            System.out.println();
        }

    }
}

