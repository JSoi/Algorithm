package programmers;

import java.util.Arrays;

public class L154539 {
    public static void main(String[] args) {
        int[] solution = new L154539().solution(new int[]{2, 3, 3, 5});
        int[] solution2 = new L154539().solution(new int[]{9, 1, 5, 3, 6, 2});
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(solution2));
    }

    public int[] solution(int[] numbers) {
        int[][] maxNumbers = new int[numbers.length][2];
        int maxNumber = -1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            maxNumber = Math.max(numbers[i], maxNumber);
            maxNumbers[i] = new int[]{maxNumber, i};
        }
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (maxNumbers[i][0] <= numbers[i]) {
                answer[i] = -1;
                continue;
            }
            for (int j = i+1; j <numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }
}
