package com.soi.baekjoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_2251 {
    private static boolean[][][] visited;
    private static int[] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        max = new int[]{a, b, c};

        visited = new boolean[a + 1][b + 1][c + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, c});
        visited[0][0][c] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to || curr[from] == 0 || curr[to] == max[to]) continue;
                    int[] next = pour(curr, from, to);
                    if (!visited[next[0]][next[1]][next[2]]) {
                        visited[next[0]][next[1]][next[2]] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        boolean[] answer = new boolean[c + 1];
        for (int bb = 0; bb <= b; bb++) {
            for (int cc = 0; cc <= c; cc++) {
                if (visited[0][bb][cc]) answer[cc] = true;
            }
        }
        System.out.println(IntStream.rangeClosed(0, max[2]).filter(i -> answer[i])
                .sorted().mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static int[] pour(int[] curr, int from, int to) {
        int[] next = Arrays.copyOf(curr, curr.length);
        int pourAmount = Math.min(max[to] - curr[to], curr[from]);
        next[to] += pourAmount;
        next[from] -= pourAmount;
        return next;
    }
}
