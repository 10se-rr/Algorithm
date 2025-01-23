package BACKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baek_12015. 가장 긴 증가하는 부분 수열 2
public class Baek_12015 {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int idx = Collections.binarySearch(list, num);
                if (idx<0) {
                    idx = -(idx + 1);
                }
                list.set(idx, num);
            }
        }
        System.out.println(list.size()-1);
    }
}

