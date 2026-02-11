package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N, L, R;

    public static void main(String[] args) throws IOException {
        input();
        int time = 0;
        while (true) {
            visited = new boolean[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        sum += bfsSum(i, j);
                    }
                }
            }
            if (sum == 0) {
                break;
            }
            time++;
        }
        System.out.println(time);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tok.nextToken());
        L = Integer.parseInt(tok.nextToken());
        R = Integer.parseInt(tok.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }

    static int bfsSum(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> visitNodes = new ArrayList<>();

        queue.offer(new int[]{r, c});
        visitNodes.add(new int[]{r, c});
        visited[r][c] = true;
        int sum = map[r][c];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cR = cur[0];
            int cC = cur[1];
            int cV = map[cR][cC];
            for (int[] d : dirs) {
                int nR = cur[0] + d[0];
                int nC = cur[1] + d[1];
                if (!isRange(nR, nC) || visited[nR][nC] || Math.abs(cV - map[nR][nC]) < L || Math.abs(cV - map[nR][nC]) > R) {
                    continue;
                }
                visited[nR][nC] = true;
                queue.offer(new int[]{nR, nC});
                visitNodes.add(new int[]{nR, nC});
                sum += map[nR][nC];
            }
        }
        if (visitNodes.size() <= 1) {
            return 0;
        }
        int avg = sum / visitNodes.size();
        for (int[] v : visitNodes) {
            map[v[0]][v[1]] = avg;
        }
        return sum;
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
