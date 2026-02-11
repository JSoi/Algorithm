package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

/**
 * <a href= "https://www.acmicpc.net/problem/9466">텀 프로젝트</a>
 */
public class BOJ_9466 {
    private static int[] arr;
    private static boolean[] isInTeam;
    private static boolean[] visited;
    private static boolean[] finished;  // 탐색 종료 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());
        while (caseCount-- > 0) {
            br.readLine();
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.append(String.valueOf(find())).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find() {
        isInTeam = new boolean[arr.length];
        visited = new boolean[arr.length];
        finished = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        int answer = 0;
        for (boolean b : isInTeam) {
            if (!b) answer++;
        }
        return answer;
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = arr[node] - 1;
        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int cycleStart = next;
            while (cycleStart != node) {
                isInTeam[cycleStart] = true; // 사이클에 속한 학생
                cycleStart = arr[cycleStart] - 1;
            }
            isInTeam[node] = true;
        }
        finished[node] = true;
    }
}
