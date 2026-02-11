package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10282 {
    private static int hacked, computerCount;
    private static List<int[]>[] conn;
    private static int[] seconds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            computerCount = Integer.parseInt(input[0]);
            int dependencies = Integer.parseInt(input[1]);
            conn = new List[computerCount];
            for (int i = 0; i < conn.length; i++) {
                conn[i] = new ArrayList<>();
            }
            for (int i = 0; i < dependencies; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                conn[b].add(new int[]{a, s});
            }
            seconds = new int[computerCount];
            Arrays.fill(seconds, Integer.MAX_VALUE);
            hacked = Integer.parseInt(input[2]) - 1;
            bfs();
            int infectedCount = 0;
            int totalSecond = 0;
            for (int second : seconds) {
                if (second == Integer.MAX_VALUE) continue;
                infectedCount++;
                totalSecond = Math.max(totalSecond, second);
            }
            bw.append(String.valueOf(infectedCount)).append(" ").append(String.valueOf(totalSecond)).append("\n");
        }
        bw.flush();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{hacked, 0});
        seconds[hacked] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // {infectedIdx, second}
            int h = cur[0];
            int s = cur[1];
            for (int[] cc : conn[h]) {
                int nextH = cc[0];
                int nextS = cc[1];
                if (seconds[nextH] <= nextS + s) continue;
                seconds[nextH] = nextS + s;
                queue.offer(new int[]{nextH, nextS + s});
            }
        }
    }

}
