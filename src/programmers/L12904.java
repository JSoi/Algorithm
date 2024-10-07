package programmers;

import java.util.Arrays;

public class L12904 {
    public static void main(String[] args) {
        L12904 test = new L12904();
        int solution = test.solution("abcdcba");
        System.out.println("solution = " + solution);

    }

    public int solution(String s) {
        int len = s.length();
        int[][] pelindrome = new int[len][len];
        for (int[] p : pelindrome) {
            Arrays.fill(p, -1);
        }
        for (int mid = 0; mid < s.length(); mid++) {
            pelindrome[mid][mid] = 1;
        }
        int max = 0;
        for (int from = 0; from < s.length(); from++) {
            for (int to = from; to < s.length(); to++) {
                String targetStr = s.substring(from, to + 1);
                if (isPalindrome(targetStr)) {
                    pelindrome[from][to] = pelindrome[to][from] = targetStr.length();
                    max = Math.max(max, targetStr.length());
                }
            }
        }
//        Arrays.stream(pelindrome).map(Arrays::toString).forEach(System.out::println);
        return max;
    }

    boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return true;
        }
        for (int i = 0; i < (len + 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
