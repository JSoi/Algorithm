package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21610 {
    private static final int[][] move = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}}; // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    private static final int[][] diag = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static int[][] map;
    private static Set<Integer> cloud;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        map = new int[n][n];
        cloud = new HashSet<>();
        cloud.addAll(Arrays.asList(n * (n - 1), n * (n - 2), n * (n - 1) + 1, n * (n - 2) + 1));
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(tok.nextToken()) - 1;
            int mag = Integer.parseInt(tok.nextToken());
            moveClouds(dir, mag);
            rain();
            copyMagic();
            createCloud();
        }
        bw.write(Arrays.stream(map).flatMapToInt(Arrays::stream).sum() + " \n");
        bw.flush();
    }

    // 구름 이동
    private static void moveClouds(int dir, int mag) {
        Set<Integer> nextCloudSet = new HashSet<>();
        for (int curr : cloud) {
            nextCloudSet.add(nextPos(curr, move[dir][0] * mag, move[dir][1] * mag));
        }
        cloud = nextCloudSet;
    }

    // 비 내림
    private static void rain() {
        for (int cloud : cloud) {
            map[cloud / n][cloud % n]++;
        }
    }

    private static void copyMagic() {
        HashMap<Integer, Integer> offsetMap = new HashMap<>();
        for (int cloud : cloud) {
            offsetMap.put(cloud, offsetMap.getOrDefault(cloud, 0) + countAdjacentCloud(cloud));
        }
        for (Map.Entry<Integer, Integer> e : offsetMap.entrySet()) {
            int pos = e.getKey();
            map[pos / n][pos % n] += e.getValue();
        }
    }

    private static void createCloud() {
        HashSet<Integer> newCloudSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !cloud.contains(i * n + j)) {
                    map[i][j] -= 2;
                    newCloudSet.add(i * n + j);
                }
            }
        }
        cloud = newCloudSet;

    }

    private static int countAdjacentCloud(int pos) {
        int count = 0;
        int r = pos / n;
        int c = pos % n;

        for (int[] d : diag) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            if (map[nr][nc] > 0) {
                count++;
            }
        }

        return count;
    }

    private static int nextPos(int currentPos, int rOffset, int cOffset) {
        int r = currentPos / n;
        int c = currentPos % n;
        int nR = r + rOffset;
        int nC = c + cOffset;
        if (nR < 0) {
            nR = n - 1 - (Math.abs(nR + 1) % n); // -1 : n-1, -2 = n-2 ..  -n = n-n
        } else {
            nR %= n;
        }
        if (nC < 0) {
            nC = n - 1 - (Math.abs(nC + 1) % n);
        } else {
            nC %= n;
        }
        return nR * n + nC;
    }
}
