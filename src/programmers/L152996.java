package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L152996 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int[][] array = Arrays.stream(weights)
                .mapToObj(weight -> new int[]{weight * 2, weight * 3, weight * 4})
                .toArray(int[][]::new);
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                seen.clear();
                seen.addAll(Arrays.asList(array[i][0], array[i][1], array[i][2]));
                for (int k = 0; k < 3; k++) {
                    if (seen.contains(array[j][k])) {
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        L152996 solution = new L152996();
        System.out.println(solution.solution(new int[]{100,180,360,100,270}));
    }
}
