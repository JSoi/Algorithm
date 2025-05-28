package com.soi.programmers;

import java.util.Arrays;

/**
 * <a href="https://programmers.co.kr/learn/courses/30/lessons/68936">쿼드압축 후 개수 세기</a>
 */
public class L68936 {
    static int zero = 0;
    static int one = 0;

    public int[] solution(int[][] arr) {
        zip(arr);
        return new int[]{zero, one};
    }

    static void zip(int[][] map) {
        int mapCount = (int) Math.pow(map.length, 2);
        int mapOneCount = (int) Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .filter(a -> a == 1).count();

        if (mapOneCount == 0) {
            zero += 1;
            return;
        }
        if (mapOneCount == mapCount) {
            one += 1;
            return;
        }

        int offset = map.length / 2;
        int[][][] subMaps = new int[4][offset][offset];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int quadrant = getQuadrant(i, j, offset);
                subMaps[quadrant][i % offset][j % offset] = map[i][j];
            }
        }
        for (int[][] subMap : subMaps) {
            zip(subMap);
        }
    }

    private static int getQuadrant(int row, int col, int mid) {
        if (row < mid && col < mid) {
            return 0; // Top Left
        } else if (row < mid) {
            return 1; // Top Right
        } else if (col < mid) {
            return 2; // Bottom Left
        } else {
            return 3; // Bottom Right
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L68936().solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
}
