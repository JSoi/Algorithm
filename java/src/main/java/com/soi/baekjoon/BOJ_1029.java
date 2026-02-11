package com.soi.baekjoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BOJ_1029 {
    int count;
    int[][] map;
    int N;
    boolean[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int[][] map = IntStream.range(0, N)
                .mapToObj(idx -> scan.nextLine().chars().map(cv -> cv - '0').toArray())
                .toArray(int[][]::new);
        int solution = new BOJ_1029().solution(map, N);
        System.out.println(solution);
    }

    private int solution(int[][] map, int N) {
        this.map = map;
        this.N = N;
        this.count = 0;
        visit = new boolean[N];
        visit[0] = true;
        dp(0, visit, map[0][0]);
        return count;
    }

    private void dp(int seller, boolean[] visit, int buyPrice) {
        count = Math.max(count, (int) IntStream.range(0, N).filter(i -> visit[i]).count());
        for (int i = 0; i < N; i++) {
            if (visit[i] || map[seller][i] < buyPrice) {
                continue;
            }
            visit[i] = true;
            dp(i, visit, map[seller][i]);
            visit[i] = false;
        }
    }
}
