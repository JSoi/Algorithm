package com.soi.programmers;

import java.util.Arrays;

public class L64062 {
    public static void main(String[] args) {
        int solution = new L64062().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 9);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] stones, int k) {
        int[] sortedArr = Arrays.copyOf(stones, stones.length);
        Arrays.sort(sortedArr);
        int l = sortedArr[0];
        int r = sortedArr[sortedArr.length - 1];
        while (l <= r) {
            int midValue = (l + r) / 2;
            if (isEnough(stones, midValue, k)) {
                l = midValue + 1;
            } else {
                r = midValue - 1;
            }
        }
        return l;
    }

    private boolean isEnough(int[] stones, int value, int maxHop) {
        int len = 0;
        for (int s : stones) {
            len = value >= s ? len + 1 : 0;
            if (len >= maxHop) {
                return false;
            }
        }
        return true;
    }

}
