package com.soi.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class POG_152996 {
    public static long solution(int[] weights) {
        Arrays.sort(weights);
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int weight : weights) {
            if (map.containsKey(weight)) answer += map.get(weight);
            if ((weight * 2) % 3 == 0 && map.containsKey((weight * 2) / 3)) answer += map.get((weight * 2) / 3);
            if (weight % 2 == 0 && map.containsKey(weight / 2)) answer += map.get(weight / 2);
            if ((weight * 3) % 4 == 0 && map.containsKey((weight * 3) / 4)) answer += map.get((weight * 3) / 4);
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        L152996 solution = new POG_152996();
        L152996 solution2 = new POG_152996();
        System.out.println(solution.solution(new int[]{100, 180, 360, 100, 270}));
//        System.out.println("L152996.main");
//        System.out.println(solution2.solution(new int[]{100, 100, 100, 100, 100}));
    }
}
