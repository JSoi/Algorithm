package programmers;

import java.lang.StringBuilder;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131128">숫자 짝꿍</a>
 */
public class L131128 {
    public static void main(String[] args) {
        System.out.println(new L131128().solution("100", "2345"));
        System.out.println(new L131128().solution("100", "203045"));
    }

    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            if (xCount[i] > 0 && yCount[i] > 0) {
                answer.append((i + "").repeat(Math.min(xCount[i], yCount[i])));
            }
        }
        if (answer.isEmpty()) return "-1";
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer.toString();
    }
}
