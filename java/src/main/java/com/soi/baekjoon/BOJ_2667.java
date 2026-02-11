package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int n, danziCount, eachCount;
    static ArrayList<Integer> list = new ArrayList<Integer>();

    static void input() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buf.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = buf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

    }

    public static void main(String[] args) throws IOException {

        input();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visit[i][j] && map[i][j] == 1) {
                    danziCount++;
                    eachCount = 0;
                    go(i, j);
                    list.add(eachCount);
                }
            }
        }
        System.out.println(danziCount);
        Collections.sort(list);
        for (int l : list) {
            System.out.println(l);
        }
    }

    static void go(int x, int y) {
        visit[x][y] = true;
        eachCount++;
        for (int k = 0; k < 4; k++) {
            if (x + dx[k] >= n || x + dx[k] < 0 || y + dy[k] >= n || y + dy[k] < 0 || visit[x + dx[k]][y + dy[k]]
                    || map[x + dx[k]][y + dy[k]] != 1) {
                continue;
            } else {
                go(x + dx[k], y + dy[k]);
            }
        }
    }

}
