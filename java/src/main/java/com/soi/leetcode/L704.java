package com.soi.leetcode;


import java.util.Arrays;

//https://leetcode.com/problems/binary-search/
public class L704 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        //Already Sorted
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = ((start + end) / 2);
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchB(int[] nums, int target) {
        int answer = Arrays.binarySearch(nums, target);
        return answer < 0 ? -1 : answer;
    }
}
