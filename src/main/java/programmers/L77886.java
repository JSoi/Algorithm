package programmers;

import java.util.Stack;

/**
 * <a href= "https://school.programmers.co.kr/learn/courses/30/lessons/77886">110 옮기기</a>
 */
public class L77886 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = replacedResult(s[i]);
        }
        return answer;
    }

    private String replacedResult(String s) {
        StringBuffer com = new StringBuffer();
        String bf = s;
        s = remove110(s);
        com.append("110".repeat((bf.length() - s.length()) / 3));
        if (s.length() == 0) {
            return com.toString();
        }
        if (s.substring(0, Math.min(3, s.length())).equals("1")) {
            return com.append("1").toString();
        }
        int pos = s.indexOf("11");
        int fZero = s.lastIndexOf("0");
        int insertPos;
        if (pos == -1) { // 10, 01, 0, 101, 00,
            insertPos = fZero + 1;
        } else {
            insertPos = pos;
        }
        return s.substring(0, insertPos) + com + s.substring(insertPos);
    }

    public static String remove110(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= 3) {
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();
                if (!(first == '1' && second == '1' && third == '0')) {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
