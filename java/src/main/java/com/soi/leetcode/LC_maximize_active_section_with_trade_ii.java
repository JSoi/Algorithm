package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_maximize_active_section_with_trade_ii {
    String s;
    int n, totalOneCount;
    int[] leftZero, rightZero;
    int[] zeroCount;
    List<Integer> answer;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        this.s = s;
        n = s.length();
        init();

        for (int[] q : queries) {
            if (!s.matches("[01]*01+0[01]*")) {
                answer.add(totalOneCount);
                continue;
            }
            int count = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                if (s.charAt(i) == '0' || leftZero[i] == -1 || rightZero[i] == -1) {
                    continue;
                }
                int l = Math.max(leftZero[i], q[0]);
                int r = Math.min(rightZero[i], q[1]);
                int max = countZero(l, r);
//                System.out.println("maxIdx : " + maxIdx + " max = " + max);
                count = Math.max(max, count);
            }
            answer.add(count + totalOneCount);
        }
        return answer;
    }

    private void init() {
        answer = new ArrayList<>();
        totalOneCount = 0;
        leftZero = new int[n];
        rightZero = new int[n];
        zeroCount = new int[n];
        if (s.charAt(0) == '0') {
            zeroCount[0] = 1;
        } else {
            leftZero[0] = -1;
            totalOneCount = 1;
        }

        rightZero[n - 1] = s.charAt(n - 1) == '0' ? n - 1 : -1;
        for (int i = 1; i < n; i++) {
            // left
            if (s.charAt(i - 1) == '1') {
                if (s.charAt(i) == '0') {
                    leftZero[i] = i;
                } else {
                    leftZero[i] = leftZero[i - 1];
                }
            } else {
                leftZero[i] = leftZero[i - 1];
            }

            // right
            int j = n - i - 1;
            if (s.charAt(j + 1) == '1') {
                if (s.charAt(j) == '0') {
                    rightZero[j] = j;
                } else {
                    rightZero[j] = rightZero[j + 1];
                }
            } else {
                rightZero[j] = rightZero[j + 1];
            }

            // zeroCount
            if (s.charAt(i) == '0') {
                zeroCount[i] = zeroCount[i - 1] + 1;
            } else {
                totalOneCount++;
                zeroCount[i] = zeroCount[i - 1];
            }
        }
    }

    private int countZero(int startInc, int endInc) {
        if (startInc == endInc) {
            return s.charAt(startInc) == '0' ? 1 : 0;
        }
        if (startInc == 0) return zeroCount[endInc];
        return zeroCount[endInc] - zeroCount[startInc - 1];
    }
}
