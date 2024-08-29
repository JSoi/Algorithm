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
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int shortestLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        // end 기준으로 진행
        while (end < sequence.length) {
            // 합일 때
            if (sum == k) {
                int diff = end - start + 1;
                if (shortestLength > diff) {
                    shortestLength = diff;
                    answer = new int[]{start, end};
                }
                sum -= sequence[start++];
            } else if (sum < k) { // 합이 작을 때
                end++;
                sum += end < sequence.length ? sequence[end] : 0;
            } else { // 합보다 클 때
                sum -= sequence[start++];
            }
        }
        return answer;
    }
}
