package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2234 {
    private static final int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // LURD
    private static int r, c;
    private static int[][] map, type;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visit = new boolean[r][c];
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int typeCount = 1;
        HashMap<Integer, Integer> typeCountMap = new HashMap<>();
        int maxSize = 0;
        type = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visit[i][j]) {
                    continue;
                }
                int size = countType(i, j, typeCount);
                maxSize = Math.max(maxSize, size);
                typeCountMap.put(typeCount, size);
                typeCount++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(typeCountMap.size() + "\n");
        bw.write(maxSize + "\n");

        int maxEliminate = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int d = 0; d < 4; d++) {
                    int nR = i + dir[d][0];
                    int nC = j + dir[d][1];
                    if ((map[i][j] & (1 << d)) == 0 || !inRange(nR, nC) || type[nR][nC] == type[i][j]) {
                        continue;
                    }
                    int otherRoomSize = typeCountMap.get(type[nR][nC]);
                    int thisRoomSize = typeCountMap.get(type[i][j]);
                    maxEliminate = Math.max(maxEliminate, otherRoomSize + thisRoomSize);
                }
            }
        }
        bw.write(maxEliminate + "\n");
        bw.flush();
    }

    private static int countType(int rr, int cc, int t) {
        int count = 0;
        visit[rr][cc] = true;
        type[rr][cc] = t;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{rr, cc});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            int curR = cur[0];
            int curC = cur[1];
            for (int d = 0; d < 4; d++) {
                int nR = curR + dir[d][0];
                int nC = curC + dir[d][1];
                if ((map[curR][curC] & (1 << d)) != 0 || !inRange(nR, nC) || visit[nR][nC]) {
                    continue;
                }
                visit[nR][nC] = true;
                type[nR][nC] = t;
                queue.offer(new int[]{nR, nC});
            }
        }
        return count;
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
