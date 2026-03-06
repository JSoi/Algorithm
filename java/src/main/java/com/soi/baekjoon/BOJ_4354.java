package com.soi.baekjoon;

import java.io.*;

/**
 * <a href = "https://www.acmicpc.net/problem/4354">문자열 제곱</a>
 */
public class BOJ_4354 {
    // 반복 문자열의 최대 길이 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!((line = br.readLine()).equals("."))) {
            bw.append(String.valueOf(findLength(line))).append("\n");
        }
        bw.flush();
    }

    private static int findLength(String input) {
        for (int len = 1; len < input.length(); len++) {
            if (isRepeatable(input, len)) {
                return input.length() / len;
            }
        }
        return 1;
    }

    private static boolean isRepeatable(String str, int len) {
        if (str.length() % len != 0) {
            return false;
        }
        String subStr = str.substring(0, len);
        for (int i = 0; i < str.length(); i += len) {
            String compare = str.substring(i, i + len);
            if (!subStr.equals(compare)) {
                return false;
            }
        }
        return true;
    }
}
