package com.soi.programmers;

/**
 * <a href= "https://school.programmers.co.kr/learn/courses/30/lessons/77886">110 옮기기</a>
 */
public class POG_77886 {
    public static String remove110(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= 3 &&
                    sb.charAt(sb.length() - 3) == '1' &&
                    sb.charAt(sb.length() - 2) == '1' &&
                    sb.charAt(sb.length() - 1) == '0') {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.toString();
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = replacedResult(s[i]);
        }
        return answer;
    }

    private String replacedResult(String s) {
        String bf = s;
        s = remove110(s);
        String com = "110".repeat((bf.length() - s.length()) / 3);
        if (s.length() == 0) {
            return com;
        }
        int fZero = s.lastIndexOf("0");
        int insertPos = fZero == -1 ? 0 : fZero + 1;
        return s.substring(0, insertPos) + com + s.substring(insertPos);
    }
}
