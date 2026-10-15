package com.soi.leetcode;

import java.util.Arrays;

public class LC_minimum_swaps_to_sort_by_digit_sum {
    public static void main(String[] args) {
        int[] nums = {18, 43, 34, 16};
        int swaps = new LC_minimum_swaps_to_sort_by_digit_sum().minSwaps(nums);
        System.out.println(swaps);
    }

    private static class Digits implements Comparable<Digits> {
        int num;
        int order;
        int digitSum;

        public Digits(int order, int num) {
            this.order = order;
            this.num = num;
            this.digitSum = makeDigit(num);
        }

        private int makeDigit(int num) {
            int result = 0;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }
            return result;
        }

        @Override
        public int compareTo(Digits other) {
            if (this.digitSum != other.digitSum) {
                return Integer.compare(this.digitSum, other.digitSum);
            }
            return Integer.compare(this.num, other.num);
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Digits[] digits = new Digits[n];
        for (int i = 0; i < n; i++) {
            digits[i] = new Digits(i, nums[i]);
        }
        Arrays.sort(digits);
        int[] orders = new int[n];
        for (int i = 0; i < n; i++) {
            orders[digits[i].order] = i;
        }
        boolean[] visited = new boolean[n];
        int cycleSize = 0;
        for (int o : orders) {
            if (visited[o]) continue;
            cycleSize++;
            int j = o;
            while (!visited[j]) {
                visited[j] = true;
                j = orders[j];
            }
        }
        return n - cycleSize;
    }

}
