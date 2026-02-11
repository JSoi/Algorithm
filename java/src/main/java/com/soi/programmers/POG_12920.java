package com.soi.programmers;

public class POG_12920 {
    public static void main(String[] args) {
        System.out.println(new POG_12920().solution(6, new int[]{1, 2, 3}));
    }

    public int solution(int n, int[] cores) {
        long left = 0;
        long right = 100_000_000L;
        while (left < right) {
            long mid = (left + right) / 2;
            if (getWorkDoneCount(cores, mid) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        long time = left;
        long doneBefore = getWorkDoneCount(cores, time - 1);
        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                doneBefore++;
                if (doneBefore == n) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    private int getWorkDoneCount(int[] cores, long time) {
        if (time < 0) return 0;
        int cnt = 0;
        for (int core : cores) {
            cnt += (int) ((time / core) + 1);
        }
        return cnt;
    }
}
