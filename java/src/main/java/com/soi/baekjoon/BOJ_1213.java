package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1213 {
    private static final String NO_ANSWER = "I'm Sorry Hansoo";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int[] count = new int['Z' - 'A' + 1];
        for (char i : input.toCharArray()) {
            count[i - 'A']++;
        }
        char[] answer = new char[input.length()];
        if (fill(answer, count)) {
            System.out.println(String.valueOf(answer));

        } else {
            System.out.println(NO_ANSWER);

        }
    }

    static boolean fill(char[] answer, int[] count) {
        for (int c = 0; c < count.length; c++) {
            char target = (char) (c + 'A');
            while (count[c] > 0) {
                if (count[c] % 2 == 1) {
                    if (answer.length % 2 == 0 || answer[answer.length / 2] > 0) {
                        return false;
                    } else {
                        answer[answer.length / 2] = target;
                        count[c] -= 1;
                    }
                } else {
                    int idx = findFirstEmptyIndex(answer);
                    answer[idx] = answer[answer.length - idx - 1] = target;
                    count[c] -= 2;
                }
            }
        }
        return true;

    }

    static int findFirstEmptyIndex(char[] answer) {
        for (int cIdx = 0; cIdx < answer.length; cIdx++) {
            if (answer[cIdx] == 0) {
                return cIdx;
            }
        }
        return -1;
    }
}
