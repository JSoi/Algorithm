package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1113 {
    static int[][] pool;
    static boolean[][] canFill;
    static int row;
    static int col;
    static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                canFill[i][j] = isEnclosed(i, j);
            }
        }

        int answer = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!canFill[i][j]) {
                    continue;
                }
                answer += getReservedVolume(i, j);
            }
        }
        System.out.println(answer);
    }


    private static int getReservedVolume(int r, int c) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> regions = new ArrayList<>();
        int height = Math.min(pool[r - 1][c], pool[r][c - 1]);
        stack.push(new int[]{r, c});
        boolean[][] visited = new boolean[row][col];
        visited[r][c] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            regions.add(pop);
            for (int[] dd : directions) {
                int nr = pop[0] + dd[0];
                int nc = pop[1] + dd[1];
                if (!inBounds(nr, nc) || visited[nr][nc]) {
                    continue;
                }
                if (!canFill[nr][nc]) {
                    height = Math.min(height, pool[nr][nc]);
                } else {
                    visited[nr][nc] = true;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
        int volume = 0;
        for (int[] rg : regions) {
            canFill[rg[0]][rg[1]] = false;
            volume += height - pool[rg[0]][rg[1]];
        }
        return volume;
    }

    private static boolean isEnclosed(int r, int c) {
        if (isBorder(r, c)) {
            return false;
        }
        boolean[][] v = new boolean[row][col];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        v[r][c] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            if (isBorder(pop[0], pop[1])) {
                return false;
            }
            for (int[] dir : directions) {
                int nRow = pop[0] + dir[0];
                int nCol = pop[1] + dir[1];
                if (!inBounds(nRow, nCol) || v[nRow][nCol]) {
                    continue;
                }
                if (pool[nRow][nCol] <= pool[r][c]) {
                    v[nRow][nCol] = true;
                    stack.push(new int[]{nRow, nCol});
                }
            }
        }
        return true;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        canFill = new boolean[row][col];
        for (boolean[] cf : canFill) {
            Arrays.fill(cf, true);
        }
        pool = new int[row][col];
        for (int i = 0; i < row; i++) {
            String row = br.readLine();
            for (int j = 0; j < col; j++) {
                pool[i][j] = Integer.parseInt(row.charAt(j) + "");
            }
        }
    }

    private static boolean inBounds(int r, int c) {
        return (r >= 0 && r < row) && (c >= 0 && c < col);
    }

    private static boolean isBorder(int i, int j) {
        return i == 0 || j == 0 || i == row - 1 || j == col - 1;
    }
}
