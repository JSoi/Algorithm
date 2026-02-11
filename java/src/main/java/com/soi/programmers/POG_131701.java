package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.Arrays;
import java.util.HashSet;

public class POG_131701 {
    public static void main(String[] args) throws Exception {
        int solution = new POG_131701().solution(new int[]{7, 9, 1, 1, 4});
        Assertions.check(solution, 18);
    }

    public int solution(int[] elements) {
        // repeat twice
        int[] map = new int[elements.length * 2];
        System.arraycopy(elements, 0, map, 0, elements.length);
        System.arraycopy(elements, 0, map, elements.length, elements.length);
        HashSet<Integer> sumSet = new HashSet<>();
        for (int len = 1; len <= elements.length; len++) {
            int sum = Arrays.stream(map, 0, len).sum();
            sumSet.add(sum);
            for (int index = 1; index + len < map.length; index++) {
                sum += map[index + len - 1] - map[index - 1];
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}
