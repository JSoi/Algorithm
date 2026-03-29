package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16946 {
    private static int[][] dp, typeMap;
    private static boolean[][] isWall, visited;
    private static int r, c;
    private static int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        isWall = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                isWall[i][j] = line.charAt(j) == '1';
            }
        }
        visited = new boolean[r][c];
        typeMap = new int[r][c];
        dp = new int[r][c];
        Map<Integer, Integer> map = new HashMap<>();
        int type = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (isWall[i][j] || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                map.put(type, bfs(i, j, type));
                type++;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!isWall[i][j]) {
                    continue;
                }
                HashSet<Integer> types = new HashSet<>();
                for (int[] mm : move) {
                    int nR = i + mm[0];
                    int nC = j + mm[1];
                    if (!inRange(nR, nC) || isWall[nR][nC]) {
                        continue;
                    }
                    types.add(typeMap[nR][nC]);
                }
                int count = 1;
                for (int tt : types) {
                    count = (map.get(tt) + count) % 10;
                }
                dp[i][j] = count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(dp[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int i, int j, int t) {
        int count = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            typeMap[curr[0]][curr[1]] = t;
            count++;
            for (int[] mm : move) {
                int nR = curr[0] + mm[0];
                int nC = curr[1] + mm[1];
                if (!inRange(nR, nC) || visited[nR][nC] || isWall[nR][nC]) {
                    continue;
                }
                visited[nR][nC] = true;
                queue.offer(new int[]{nR, nC});
            }
        }
        return count;
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
