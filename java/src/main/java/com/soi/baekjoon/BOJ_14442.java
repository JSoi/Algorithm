package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442 {
    private static boolean[][] map;
    private static boolean[][][] visited;

    private static final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int r, c, collisionCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        collisionCount = Integer.parseInt(st.nextToken());
        visited = new boolean[r][c][collisionCount + 1];
        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 1}); // contains start & end
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == r - 1 && curr[1] == c - 1) {
                System.out.println(curr[3]);
                return;
            }
            // ans
            int cColl = curr[2];
            for (int[] mm : movement) {
                int nR = curr[0] + mm[0];
                int nC = curr[1] + mm[1];
                int nColl;
                int nDist = curr[3] + 1;
                if (!inRange(nR, nC)) continue;
                if (map[nR][nC]) { // collide
                    nColl = cColl + 1;
                    if (nColl <= collisionCount && !visited[nR][nC][nColl]) {
                        changeVisitState(nR, nC, nColl);
                        queue.offer(new int[]{nR, nC, nColl, nDist});
                    }
                } else {
                    nColl = cColl;
                    if (!visited[nR][nC][nColl]) {
                        changeVisitState(nR, nC, nColl);
                        queue.offer(new int[]{nR, nC, nColl, nDist});
                    }
                }
            }
        }
        System.out.println(-1);
    }


    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static void changeVisitState(int rr, int cc, int coll) {
        for (int i = coll; i <= collisionCount; i++) {
            visited[rr][cc][i] = true;
        }
    }
}
