package programmers;

import java.util.Stack;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/389480">완전 범죄</a>
 */
public class L389480 {
    public static void main(String[] args) {
        System.out.println(new L389480().solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4));
    }

    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        Stack<Status> stack = new Stack<>();
        stack.push(new Status(-1, 0, 0));
        while (!stack.isEmpty()) {
            Status recent = stack.pop();
            int recentIdx = recent.index;
            if (recentIdx == info.length - 1) {
                answer = Math.min(answer, recent.aSum);
                continue;
            }
            if (recent.aSum + info[recentIdx + 1][0] < n) {
                stack.push(new Status(recentIdx + 1, recent.aSum + info[recentIdx + 1][0], recent.bSum));
            }
            if (recent.bSum + info[recentIdx + 1][1] < m) {
                stack.push(new Status(recentIdx + 1, recent.aSum, recent.bSum + info[recentIdx + 1][1]));
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static class Status {
        int index;
        int aSum;
        int bSum;

        public Status(int index, int aSum, int bSum) {
            this.index = index;
            this.aSum = aSum;
            this.bSum = bSum;
        }
    }
}
