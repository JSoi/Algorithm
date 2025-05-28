package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String line2 = br.readLine();

        String a = line.length() < line2.length() ? line : line2;
        String b = line.length() < line2.length() ? line2 : line;

        int answer = a.length() + b.length();

        for (int offset = -a.length(); offset <= b.length(); offset++) {
            if (isCompatible(offset, a, b)) {
                int left = Math.min(offset, 0);
                int right = Math.max(offset + a.length(), b.length());
                int totalLen = right - left;
                answer = Math.min(answer, totalLen);
            }
        }

        System.out.println(answer);
    }

    static boolean isCompatible(int offset, String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            int bIdx = i + offset;
            if (bIdx < 0 || bIdx >= b.length()) continue;

            int aa = a.charAt(i) - '0';
            int bb = b.charAt(bIdx) - '0';
            if (aa + bb > 3) return false;
        }
        return true;
    }
}
