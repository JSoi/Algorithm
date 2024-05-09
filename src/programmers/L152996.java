package programmers;

import java.util.*;

public class L152996 {
    public static final int[] dist = {2, 3, 4};
    // weight, index
    public static Map<Integer, Set<Integer>> setMap = new HashMap<>();

    public static long solution(int[] weights) {
        int answer = 0;
        Arrays.sort(weights);
        for (int k = 0; k < weights.length; k++) {
            answer += getElement(weights[k], k);
            for(int d : dist){
                setMap.computeIfAbsent(weights[k] * d, key -> new HashSet<>()).add(k);
            }
        }
        return answer;
    }

    public static int getElement(int original, int index) {
        Set<Integer> elements = new HashSet<>();
        for(int d : dist){
            elements.addAll(setMap.getOrDefault(original * d, Set.of()));
        }
        elements.remove(index);
        return elements.size();
    }

    public static void main(String[] args) {
        L152996 solution = new L152996();
        L152996 solution2 = new L152996();
        System.out.println(solution.solution(new int[]{100, 180, 360, 100, 270}));
//        System.out.println("L152996.main");
//        System.out.println(solution2.solution(new int[]{100, 100, 100, 100, 100}));
    }
}
