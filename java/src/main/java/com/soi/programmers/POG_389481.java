package com.soi.programmers;

import java.util.Arrays;

public class POG_389481 {
    public String solution(long n, String[] bans) {
        long[] bansToNum = Arrays.stream(bans).map(a -> toNumber(a))
                .mapToLong(Long::longValue).sorted().toArray();
        for (long l : bansToNum) {
            if (n >= l) {
                n++;
            }
        }
        return toStr(n);
    }

    private static long toNumber(String num) {
        long offset = 1;
        long result = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            result += offset * (num.charAt(i) - 'a' + 1);
            offset *= 26;
        }
        return result;
    }

    private static String toStr(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--;
            sb.insert(0, (char) ('a' + num % 26));
            num /= 26;
        }
        return sb.toString();
    }
}
