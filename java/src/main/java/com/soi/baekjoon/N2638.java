package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2638 {
    private static int[] map;
    private static int r, c;
    private static final int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static Set<Integer> outerPos = new HashSet<>();
    private static Set<Integer> cheesePos = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        map = new int[r * c];
        for (int i = 0; i < r; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                int value = Integer.parseInt(tok.nextToken());
                if (j == 0 || j == c - 1 || i == 0 || i == r - 1) {
                    outerPos.add(i * c + j);
                    continue;
                }

                if (value == 1) {
                    cheesePos.add(i * c + j);
                    map[i * c + j] = 1;
                } else {
                    map[i * c + j] = -1; // inner blank
                }
            }
        }
        outer();
        int time = 0;
        while (!cheesePos.isEmpty()) {
            time++;
            melt();
            outer();
        }
        System.out.println(time);

    }

    private static void outer() {
        HashSet<Integer> newOuterPos = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>(outerPos);
        boolean[] visited = new boolean[r * c];
        while (!queue.isEmpty()) {
            int out = queue.poll();
            int cr = out / c;
            int cc = out % c;
            for (int[] m : move) {
                if (cr + m[0] < 0 || cr + m[0] >= r || cc + m[1] < 0 || cc + m[1] >= c || visited[(cr + m[0]) * c + (cc + m[1])]) {
                    continue;
                }
                int np = (m[0] + cr) * c + (m[1] + cc);
                visited[np] = true;
                if (map[np] == 1) {
                    continue;
                }
                map[np] = 0;
                queue.offer(np);
                newOuterPos.add(np);
            }
        }
        outerPos.addAll(newOuterPos);
    }

    private static void melt() {
        HashSet<Integer> meltPos = new HashSet<>();
        for (int cheese : cheesePos) {
            int cr = cheese / c;
            int cc = cheese % c;
            int count = 0;
            for (int[] m : move) {
                if (cr + m[0] < 0 || cr + m[0] >= r || cc + m[1] < 0 || cc + m[1] >= c) {
                    continue;
                }
                int np = (m[0] + cr) * c + (m[1] + cc);
                if (outerPos.contains(np)) {
                    count++;
                }
            }
            if (count >= 2) {
                meltPos.add(cheese);
            }
        }
        for (int melt : meltPos) {
            cheesePos.remove(melt);
            map[melt] = 0;
            outerPos.add(melt);
        }
    }
}
