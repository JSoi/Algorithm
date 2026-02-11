package com.soi.programmers;

import java.util.HashMap;
import java.util.HashSet;

public class POG_250136 {
    final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int fuelColumnSum;
    int[][] fuelInfo;
    int[][] land;

    public static void main(String[] args) {
        int solution = new POG_250136().solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] land) {
        this.land = land;
        fuelInfo = new int[land.length][land[0].length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int landCount = 1;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                fuelColumnSum = 0;
                if (fuelInfo[i][j] == 0 && land[i][j] == 1) {
                    fuelSum(i, j, landCount);
                    map.put(landCount, fuelColumnSum);
                    landCount++;
                }
            }
        }
        int fuelSum = 0;
        for (int c = 0; c < land[0].length; c++) {
            HashSet<Integer> landType = new HashSet<>();
            for (int r = 0; r < land.length; r++) {
                if (fuelInfo[r][c] > 0) {
                    landType.add(fuelInfo[r][c]);
                }
            }
            int columnSum = landType.stream().mapToInt(map::get)
                    .reduce((Integer::sum)).orElse(0);
            fuelSum = Math.max(columnSum, fuelSum);
        }
        return fuelSum;
    }

    private void fuelSum(int r, int c, int landCount) {
        fuelInfo[r][c] = landCount;
        fuelColumnSum++;
        for (int[] d : dir) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextR >= land.length || nextC < 0 || nextC >= land[0].length ||
                    land[nextR][nextC] == 0 || fuelInfo[nextR][nextC] != 0) {
                continue;
            }
            fuelSum(nextR, nextC, landCount);
        }
    }
}
