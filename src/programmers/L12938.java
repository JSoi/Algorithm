package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L12938 {
    public static void main(String[] args) {
        int[] solution = new L12938().solution(2, 9);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        List<Integer> answerList = new LinkedList<>();
        while (n > 0) {
            answerList.add(s / n);
            s -= (s / n);
            n--;
        }
        return answerList.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }
}
