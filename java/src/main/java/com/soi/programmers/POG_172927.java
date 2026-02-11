package com.soi.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/172927">광물 캐기</a>
 */
public class POG_172927 {
    static final int[][] fatigue = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    static int[][] fatigueMap;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] pick1 = new int[]{1, 3, 2};
        String[] mineral1 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(pick1, mineral1));
    }


    public static int solution(int[] picks, String[] minerals) {
        fatigueMap = new int[minerals.length / 5 + 1][3];
        for (int i = 0; i < minerals.length / 5 + 1; i++) {
            String[] subMinerals = Arrays.copyOfRange(minerals, i * 5, Math.min(minerals.length, (i + 1) * 5));
            fatigueMap[i] = IntStream.range(0, 3).map(j -> calculateFatigue(j, subMinerals)).toArray();
        }
        mine(picks, 0, 0);
        return min;
    }


    static void mine(int[] picks, int fatigueMapIdx, int fatigueSum) {
        if (fatigueMapIdx == fatigueMap.length || Arrays.stream(picks).reduce(0, Integer::sum) == 0) {
            if (min > fatigueSum) {
                min = fatigueSum;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                mine(picks, fatigueMapIdx + 1, fatigueSum + fatigueMap[fatigueMapIdx][i]);
                picks[i]++;
            }
        }
    }

    public static int calculateFatigue(int pick, String[] minerals) {
        int fatiuge = 0;
        for (String mineral : minerals) {
            if (mineral.equals("diamond")) {
                fatiuge += fatigue[pick][0];
            } else if (mineral.equals("iron")) {
                fatiuge += fatigue[pick][1];
            } else {
                fatiuge += fatigue[pick][2];
            }
        }
        return fatiuge;
    }
}
