package programmers;

import java.util.Arrays;

public class L161990 {
    private static class Solution {
        public int[] solution(String[] wallpaper) {
            int startX = Integer.MAX_VALUE;
            int startY = Integer.MAX_VALUE;
            int endX = 0;
            int endY = 0;

            for (int i = 0; i < wallpaper.length; i++) {
                for (int j = 0; j < wallpaper[i].length(); j++) {
                    if (wallpaper[i].charAt(j) == '#') {
                        startX = Math.min(startX, i);
                        startY = Math.min(startY, j);
                        endX = Math.max(endX, i);
                        endY = Math.max(endY, j);
                    }
                }
            }
            return new int[]{startX, startY, endX + 1, endY + 1};
        }
    }

    public static void main(String[] args) {
        String[] case1 = {".#...", "..#..", "...#."};
        String[] case2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] case3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] case4 = {"..", "#."};
        Solution sol1 = new Solution();
        System.out.println(Arrays.toString(sol1.solution(case1)));
        System.out.println(Arrays.toString(sol1.solution(case2)));
        System.out.println(Arrays.toString(sol1.solution(case3)));
        System.out.println(Arrays.toString(sol1.solution(case4)));
    }
}
