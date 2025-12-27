package com.soi.baekjoon;

import java.io.*;

public class N17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(findPalindromeType(br.readLine()) + "\n");
        }
        bw.flush();
    }

    private static int findPalindromeType(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            if (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
