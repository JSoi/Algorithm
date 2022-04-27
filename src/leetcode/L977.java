package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class L977 {
    public static void main(String[] args) {
    }

    @Test
    public void mytest() {
        int input[] = new int[]{-7, -3, 2, 3, 11};
        int expect[] = new int[]{4, 9, 9, 49, 121};
        Assert.assertTrue(Arrays.equals(sortedSquares(input),expect));

    }

    public int[] sortedSquares(int[] nums) {
        int[] pow = Arrays.stream(nums).map(n -> n * n).toArray();
        Arrays.sort(pow);
        return pow;
    }
}
