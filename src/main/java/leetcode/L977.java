package leetcode;

import java.util.Arrays;

public class L977 {
    public static void main(String[] args) {
    }

    public int[] sortedSquares(int[] nums) {
        int[] pow = Arrays.stream(nums).map(n -> n * n).toArray();
        Arrays.sort(pow);
        return pow;
    }
}
