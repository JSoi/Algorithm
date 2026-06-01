package com.soi.leetcode;

public class LC_count_integers_with_even_digit_sum {
    static class Solution {
        public int countEven(int num) {
            int answer = 0;
            for (int i = 1; i <= num; i++) {
                if (isEvenDigit(i)) answer++;
            }
            return answer;
        }

        private boolean isEvenDigit(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum % 2 == 0;
        }
    }
}
