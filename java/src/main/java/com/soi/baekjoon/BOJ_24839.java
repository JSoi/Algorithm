package com.soi.baekjoon;

import java.io.*;

public class BOJ_24839 {
    private static final String format = "Case #%d: %s";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int c = 1; c <= testCase; c++) {
            String correct = br.readLine();
            String input = br.readLine();
            int count = deleteCount(correct, input);
            if (count == -1) {
                bw.append(String.format(format, c, "IMPOSSIBLE")).append("\n");
            } else {
                bw.append(String.format(format, c, count)).append("\n");
            }
        }
        bw.flush();
    }

    private static int deleteCount(String answer, String input) {
        if (answer.length() > input.length()) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        int aIdx = 0;
        for (int i = 0; i < input.length() && aIdx < answer.length(); i++) {
            if (input.charAt(i) == answer.charAt(aIdx)) {
                sb.append(answer.charAt(aIdx));
                aIdx++;
            }
        }
        String correct = sb.toString();
        if (correct.equals(answer)) {
            return input.length() - sb.length();
        }

        return -1;
    }
}
