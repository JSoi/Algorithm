package programmers;

import java.util.Arrays;

public class L178870 {
    public static void main(String[] args) {
        int[] case1 = new L178870().solution(new int[]{1, 2, 3, 4, 5}, 7);
        int[] case2 = new L178870().solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        int[] case3 = new L178870().solution(new int[]{2, 2, 2, 2, 2}, 6);
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
        System.out.println(Arrays.toString(case3));

    }

    public int[] solution(int[] sequence, int k) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < sequence.length; i++) {
            int[] sum = new int[sequence.length];
            sum[i] = sequence[i];
            if (sum[i] == k) {
                return new int[]{i, i};
            }
            for (int j = i + 1; j < sequence.length; j++) {
                sum[j] = sum[j - 1] + sequence[j];
                if (sum[j] == k) {
                    if (start == -1 || ((end - start) > (j - i))) {
                        start = i;
                        end = j;
                    }
                    break;
                }
            }
        }
        return new int[]{start, end};
    }
}
