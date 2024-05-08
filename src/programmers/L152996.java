package programmers;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class L152996 {
    public static final int[] dist = {2, 3, 4};

    public long solution(int[] weights) {
        int answer = 0;
        Arrays.sort(weights);
        Map<Integer, Set<Integer>> seenCount = new HashMap<>();
        int index = 0;
        for (int weight : weights) {
            for (int d : dist) {
                seenCount.computeIfAbsent(index, k -> new HashSet<>()).add(weight * d);
            }
            index++;
        }
        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                if (contains(seenCount.get(i), seenCount.get(j))) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean contains(Set<Integer> set1, Set<Integer> set2) {
        for (int s1 : set1) {
            if (set2.contains(s1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L152996 solution = new L152996();
        System.out.println(solution.solution(new int[]{100, 180, 360, 100, 270}));
    }
}
