package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N16928 {
    private static Map<Integer, Integer> jump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int ladderCount = Integer.parseInt(tok.nextToken());
        int snakeCount = Integer.parseInt(tok.nextToken());

        jump = new HashMap<>();
        for (int i = 0; i < ladderCount; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            jump.put(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
        }

        for (int i = 0; i < snakeCount; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            jump.put(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
        }
        int answer = bfs(1);
        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 100) {
                return cur[1];
            }
            for (int i = 1; i <= 6; i++) { // 일반 주사위
                int next = cur[0] + i;
                if (next > 100 || visited[next]) {
                    continue;
                }
                if (jump.containsKey(next)) {
                    if (!visited[jump.get(next)]) {
                        visited[jump.get(next)] = true;
                        queue.offer(new int[]{jump.get(next), cur[1] + 1});
                    }
                } else {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return answer;
    }
}
