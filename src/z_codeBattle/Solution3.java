package z_codeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3 {
    static class Problem implements Comparable<Problem> {
        String name; // 이름
        int grade;    // 등급

        public Problem(String name, int grade) { // 생성자
            this.name = name;
            this.grade = grade;
        }

        public int compareTo(Problem other) {
            if (this.grade != other.grade) {
                return this.grade - other.grade; // 등급 오름차순
            } else {
                return this.name.compareTo(other.name); // 이름 사전 순
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append('#').append(t).append(' ');

            int N = Integer.parseInt(br.readLine());

            // 문제들을 저장할 리스트 생성
            List<Problem> problems = new ArrayList<>();

            // N개의 문제에 대해 반복
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                String name = st.nextToken();// 문제의 이름
                int grade = Integer.parseInt(st.nextToken()); // 문제의 등급

                // 문제 인스턴스를 생성하여 리스트에 추가
                problems.add(new Problem(name, grade));
            }

            // 문제들을 정렬 (Problem 클래스의 compareTo 메서드에 의해 정렬됨)
            Collections.sort(problems);

            for (Problem p : problems) {
                sb.append(p.name).append(' ');
            }
            sb.append('\n');
        }

        //출력
        System.out.print(sb);
    }
}

