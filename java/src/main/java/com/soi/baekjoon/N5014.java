package com.soi.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5014 {
    private static final String IMPOSSIBLE = "use the stairs";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] moves = new int[]{sc.nextInt(), -sc.nextInt()};

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[total + 1];
        visited[start] = true;
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currentFloor = curr[0];
            int buttonClickedCount = curr[1];
            if (currentFloor == end) {
                System.out.println(buttonClickedCount);
                return;
            }
            for (int m : moves) {
                int nextFloor = currentFloor + m;
                if (nextFloor <= 0 || nextFloor > total || visited[nextFloor]) {
                    continue;
                }
                visited[nextFloor] = true;
                queue.add(new int[]{nextFloor, buttonClickedCount + 1});
            }
        }
        System.out.println(IMPOSSIBLE);
    }
}
