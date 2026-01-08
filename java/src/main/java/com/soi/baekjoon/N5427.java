package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5427 {
    public static final int MAX = Integer.MAX_VALUE;
    public static final int[][] mv = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int r, c;
    private static char[][] map;
    private static int[][] fireCount;
    private static final String IMP = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());
        while (caseCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            fireCount = new int[r][c];
            int startR = 0, startC = 0;
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        startR = i;
                        startC = j;
                    }
                }
            }
            calculateFireTime();
//            System.out.println(Arrays.deepToString(fireCount));
            int answer = getStepCount(startR, startC);
            bw.write((answer == MAX ? IMP : answer) + "\n");
        }
        bw.flush();
    }

    private static boolean isExit(int rr, int cc) {
        return (rr == r-1 || cc == c-1 || rr == 0 || cc == 0) && map[rr][cc] != '#';
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static void calculateFireTime() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] f : fireCount) {
            Arrays.fill(f, MAX);
        }
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    queue.add(new int[]{i, j, 0});
                    fireCount[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int[] m : mv) {
                int nR = cr + m[0];
                int nC = cc + m[1];
                if (!inRange(nR, nC) || map[nR][nC] != '.' || visited[nR][nC]) continue;
                visited[nR][nC] = true;
                fireCount[nR][nC] = cur[2] + 1;
                queue.add(new int[]{nR, nC, cur[2] + 1});
            }
        }
    }

    private static int getStepCount(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0});
        boolean[][] visited = new boolean[r][c];
        visited[startR][startC] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            if (isExit(cr, cc)) {
                return cur[2] + 1;
            }
            for (int[] m : mv) {
                int nR = cr + m[0];
                int nC = cc + m[1];
                if (!inRange(nR, nC) || map[nR][nC] == '#' || visited[nR][nC] || fireCount[nR][nC] <= cur[2] + 1) {
                    continue;
                }
                visited[nR][nC] = true;
                queue.add(new int[]{nR, nC, cur[2] + 1});
            }
        }
        return MAX;
    }
}
