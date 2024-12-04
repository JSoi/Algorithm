package programmers;

import java.util.*;

public class L154539 {
    public static void main(String[] args) {
        int[] solution = new L154539().solution(new int[]{2, 3, 3, 5});
        int[] solution2 = new L154539().solution(new int[]{9, 1, 5, 3, 6, 2});
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(solution2));
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        return answer;
    }
}
