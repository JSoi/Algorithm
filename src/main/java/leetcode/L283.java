package leetcode;



import java.util.Arrays;

public class L283 {

    public void moveZeroes(int[] nums) { // 시간이 너무 오래 걸린다 ... 그래서 수정
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                go(i, last--, nums);
            }
            for (int j = 0; j < last; j++) {
                if (nums[j] == 0) {
                    go(j, last--, nums);
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int zeroCount = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int index = i;
                while (index + 1 < nums.length - zeroCount) {
                    swap(index, index + 1, nums);
                    index++;
                }
                zeroCount++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroCount++] = nums[i];
            }
        }
        while (zeroCount < nums.length) {
            nums[zeroCount++] = 0;
        }
    }

    public void go(int start, int target, int[] nums) {
        while (start < target && start + 1 < nums.length) {
            swap(start, start + 1, nums);
            start++;
        }
    }

    public void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
