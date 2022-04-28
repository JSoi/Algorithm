package leetcode;

public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        do {
            if (numbers[low] + numbers[high] > target) {
                int bfVal = numbers[high];
                do {
                    high--;
                } while (bfVal == numbers[high]);
            } else if (numbers[low] + numbers[high] < target) {
                int bfVal = numbers[low];
                do {
                    low++;
                } while (bfVal == numbers[low]);
            } else {
                return new int[]{low + 1, high + 1};
            }
        } while (low < high);
        return null;
    }
}
