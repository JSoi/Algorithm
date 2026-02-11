package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235 {
    static final int[][] movement = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int N;
    static int[][] food, initialFood;
    static List<Integer>[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());
        food = new int[N][N];
        initialFood = new int[N][N];
        tree = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tree[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < N; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                initialFood[i][j] = Integer.parseInt(tok.nextToken());
                food[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(tok.nextToken()) - 1;
            int c = Integer.parseInt(tok.nextToken()) - 1;
            int age = Integer.parseInt(tok.nextToken());
            tree[r][c].add(age);
        }
        while (K-- > 0) {
            grow();
            breed();
            giveFoods();
        }
        System.out.println(count());
    }

    private static void grow() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                List<Integer> t = tree[r][c];
                List<Integer> nt = new ArrayList<>();
                if (t.isEmpty()) continue;
                Collections.sort(t);
                int nextFood = 0;
                for (int age : tree[r][c]) {
                    if (age > food[r][c]) { // 부족
                        nextFood += age / 2;
                    } else {
                        food[r][c] -= age;
                        nt.add(age + 1);
                    }
                }
                food[r][c] += nextFood;
                tree[r][c] = nt;
            }
        }
    }


    private static void breed() {
        HashMap<Integer, Integer> childMap = new HashMap<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                List<int[]> nP = getFurnishPoints(r, c);
                for (int t : tree[r][c]) {
                    if (t % 5 != 0) continue;
                    for (int[] points : nP) {
                        int nextPoint = points[0] * N + points[1];
                        childMap.put(nextPoint, childMap.getOrDefault(nextPoint, 0) + 1);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> e : childMap.entrySet()) {
            int row = e.getKey() / N;
            int col = e.getKey() % N;
            int count = e.getValue();
            while (count-- > 0) {
                tree[row][col].add(0, 1);
            }
        }
    }

    private static List<int[]> getFurnishPoints(int r, int c) {
        ArrayList<int[]> nextPoints = new ArrayList<>();
        for (int[] m : movement) {
            int nR = m[0] + r;
            int nC = m[1] + c;
            if (inRange(nR, nC)) nextPoints.add(new int[]{nR, nC});
        }
        return nextPoints;
    }

    private static void giveFoods() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                food[r][c] += initialFood[r][c];
            }
        }
    }

    private static int count() {
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                count += tree[r][c].size();
            }
        }
        return count;
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
