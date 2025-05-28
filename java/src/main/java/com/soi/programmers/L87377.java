package com.soi.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class L87377 {
    public static void main(String[] args) {
        new L87377().solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}});
    }

    public String[] solution(int[][] line) {
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        HashSet<long[]> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long incline = a * d - b * c;
                if (incline == 0 || (b * f - e * d) % incline != 0 || (e * c - a * f) % incline != 0) {
                    continue;
                }
                long x = (b * f - e * d) / incline;
                long y = (e * c - a * f) / incline;

                minX = Math.min(x, minX);
                maxX = Math.max(x, maxX);
                minY = Math.min(y, minY);
                maxY = Math.max(y, maxY);
                set.add(new long[]{x, y});
            }
        }

        String[] answer = new String[(int) (maxY - minY + 1)];
        String l = ".".repeat((int) (maxX - minX + 1));
        Arrays.fill(answer, l);

        for (long[] s : set) {
            char[] charArray = answer[(int) Math.abs(maxY - s[1])].toCharArray();
            charArray[(int) (s[0] - minX)] = '*';
            answer[(int) (maxY - s[1])] = String.valueOf(charArray);
        }
        return answer;
    }

}
