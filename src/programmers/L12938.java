package programmers;

import java.util.Arrays;

public class L12938 {
    public static void main(String[] args) {
        int[] solution = new L12938().solution(4, 15);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int answerIdx = 0;
        while (n > 0) {
            answer[answerIdx++] = s / n;
            s -= (s / n);
            n--;
        }
        return answer;
    }
}
