package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1342 {
    static int[] charCount;
    static int len;
    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] chars = scan.nextLine().toCharArray();
        answer = 0;
        len = chars.length;
        charCount = new int['z' - 'a' + 1];
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        bt(0, "");
        System.out.println(answer);
    }

    private static void bt(int index, String currentStr) {
        if (index == len) {
            answer++;
            return;
        }
        for (int i = 0; i < charCount.length; i++) {
            char charToAdd = (char) (i + 'a');
            // filter if adjacent character is same
            if (charCount[i] == 0 ||
                    (!currentStr.isBlank() && currentStr.charAt(index - 1) == charToAdd)) {
                continue;
            }
            charCount[i]--;
            bt(index + 1, currentStr + charToAdd);
            charCount[i]++;
        }
    }
}