package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static final String conStr = "aeiou";
    static List<String> answer;
    static int L, C;
    static BufferedReader br;
    static boolean[] isCon;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            char c = tok.nextToken().charAt(0);
            chars[i] = c;
        }
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (conStr.contains(String.valueOf(c))) {
                isCon[i] = true;
            }
        }
        dp(0, 2, 1, "");
        for (String a : answer) {
            System.out.println(a);
        }
    }

    private static void dp(int currentIdx, int leftV, int leftC, String curr) {
        if (curr.length() == L) {
            if (leftV <= 0 && leftC <= 0) {
                answer.add(curr);
            }
            return;
        }
        for (int i = currentIdx; i < chars.length; i++) {
            char c = chars[i];
            boolean con = isCon[i];
            int nextV = leftV - (con ? 0 : 1);
            int nextC = leftC - (con ? 1 : 0);
            dp(i + 1, nextV, nextC, curr + c);
        }
    }

    private static void init() throws IOException {
        answer = new ArrayList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        L = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        chars = new char[C];
        isCon = new boolean[C];
    }
}
