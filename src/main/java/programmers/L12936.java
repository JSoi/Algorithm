package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L12936 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L12936().solution(3, 5)));
    }

    public static int[] solution(int n, long k) {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        int[] answer = new int[n];
        int index = 0;
        long div = factorial(n);
        while (!candidates.isEmpty()) {
            div /= n--;
            int pickIndex = (int) ((k - 1) / div);
            int toUse = candidates.get(pickIndex);
            candidates.remove(pickIndex);
            k -= pickIndex * div;
            answer[index++] = toUse;
        }
        return answer;
    }

    private static long factorial(int targetSize) {
        if (targetSize <= 1) {
            return 1;
        }
        long answer = 1;
        for (int i = 1; i <= targetSize; i++) {
            answer *= i;
        }
        return answer;
    }
}
