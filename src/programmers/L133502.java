package programmers;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/133502">햄버거 만들기</a>
 */
public class L133502 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int solution = new L133502().solution(ingredient);
        System.out.println(solution);
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder s = new StringBuilder();
        for (int i : ingredient) {
            s.append(i);
            if (s.length() >= 4 && s.substring(s.length() - 4).equals("1231")) {
                s.delete(s.length() - 4, s.length());
                answer++;
            }
        }
        return answer;
    }

}

