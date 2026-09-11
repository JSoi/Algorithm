package com.soi.leetcode;

public class LC_unique_3_digit_even_numbers {
    private int answer;
    private int n;
    private int[] arr;

    public static void main(String[] args) {
        LC_unique_3_digit_even_numbers solution = new LC_unique_3_digit_even_numbers();
        int[] digits = {1,2,3,4};
        int result = solution.totalNumbers(digits);
        System.out.println(result);
    }

    public int totalNumbers(int[] digits) {
        // even
        arr = new int[10];
        n = digits.length;

        for (int d : digits) {
            arr[d]++;
        }
        // 3digit
        // last digit must be even, so we can only use 0, 2, 4, 6, 8
        for (int i = 0; i <= 8; i += 2) {
            if(arr[i] == 0) continue;
            arr[i] -= 1;
            combination(0);
            arr[i] += 1;
        }
        return answer;
    }

    void combination(int idx) {
        if (idx == 2) {
            answer++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] == 0 || (idx == 0 && i == 0)) continue;
            arr[i] -= 1;
            combination(idx + 1);
            arr[i] += 1;
        }
    }
}
