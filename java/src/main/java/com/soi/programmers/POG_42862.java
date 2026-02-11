package com.soi.programmers;

import java.util.Arrays;

public class POG_42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] extra = new int[n];
        Arrays.fill(extra, 1);
        for (int r : reserve) {
            extra[r - 1]++;
        }
        for (int l : lost) {
            extra[l - 1]--;
        }
        for (int j = 0; j < n; j++) {
            if (extra[j] == 0) {
                if (j - 1 >= 0 && extra[j - 1] == 2) {
                    extra[j - 1]--;
                } else if (j + 1 < n && extra[j + 1] == 2) {
                    extra[j + 1]--;
                } else {
                    continue;
                }
                extra[j]++;
            }
        }
        for (int ch : extra) {
            answer = ch > 0 ? answer + 1 : answer;
        }
        return answer;
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        int[] st = new int[n + 2];
        for (int k = 1; k <= n; k++) {
            st[k] = 1;
        }

        for (int k = 0; k < reserve.length; k++) {
            st[reserve[k]]++;
        }
        for (int k = 0; k < lost.length; k++) {
            st[lost[k]]--;
        }
        for (int k = 1; k <= n; k++) {
            if (st[k] == 0) {
                if (st[k - 1] == 2) {
                    st[k - 1]--;
                    st[k]++;
                } else if (st[k + 1] == 2) {
                    st[k + 1]--;
                    st[k]++;
                }
            }
        }
        int answer = n;
        for (int k = 1; k <= n; k++) {
            if (st[k] == 0) {
                answer--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] a = {2, 4}; // 0 1 1 1 0 1 0
        int[] b = {3};
        System.out.println(solution(5, a, b));
    }

}
