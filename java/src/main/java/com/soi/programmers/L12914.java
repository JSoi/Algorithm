package com.soi.programmers;

import com.soi.tool.Assertions;

public class L12914 {
    public static void main(String[] args) throws Exception {
        long solution1 = new L12914().solution(4);// 5
//        long solution2 = new L12914().solution(3); // 3
        Assertions.check(solution1, 5L);
//        Assertions.check(solution2, 3L);
    }

    public long solution(int n) {
        if (n <= 2) {
            return n;
        }
        long[] arr = new long[n + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i <= 2) {
                arr[i] = i;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
            }
        }
        return arr[n];
    }

}
