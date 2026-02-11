package com.soi.programmers;

import com.soi.tool.Assertions;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/68935">3진법 뒤집기</a>
 */
public class POG_68935 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new POG_68935().solution(45), 7);
        Assertions.check(new POG_68935().solution(125), 229);

        Assertions.check(new POG_68935().solution2(45), 7);
        Assertions.check(new POG_68935().solution2(125), 229);
    }

    public int solution(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.append(n % 3);
            n /= 3;

        }
        int toTenResult = 0;
        char[] resultChar = result.toString().toCharArray();
        for (int c = 0; c < resultChar.length; c++) {
            toTenResult += (int) Math.pow(3, resultChar.length - c - 1.0) * (resultChar[c] - '0');
        }
        return toTenResult;
    }

    public int solution2(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(result.toString(), 3);
    }
}
