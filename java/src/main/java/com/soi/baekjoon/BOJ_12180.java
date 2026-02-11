package com.soi.baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_12180 {
    public static final String CASE_WRITER = "Case #%d: %d";
    // 상, 우, 하, 좌
    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            try {
                String[] input = br.readLine().split(" ");
                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                bw.append(String.format(CASE_WRITER, i, backtracking(0, 0, r, c, 1, new boolean[r * c])))
                        .append("\n");
            } catch (Exception e) {
                break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int backtracking(int r, int c, int totalR, int totalC, int dir, boolean[] visit) {
        if (r < 0 || r >= totalR || c < 0 || c >= totalC || visit[r * totalC + c]) {
            return 0;
        }
        visit[r * totalC + c] = true;
        int value = 0;
        int nextR = r + DIR[dir][0];
        int nextC = c + DIR[dir][1];
        value += backtracking(nextR, nextC, totalR, totalC, dir, visit);

        int newDir = (dir + 1) % 4;
        nextR = r + DIR[newDir][0];
        nextC = c + DIR[newDir][1];
        value += backtracking(nextR, nextC, totalR, totalC, newDir, visit);
        visit[r * totalC + c] = false;
        return Math.max(value, 1);
    }
    // stack 사용 풀이 추가

    static int solution(int r, int c) {
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        boolean[] v = new boolean[r * c];
        stack.push(new Node(0, 0, 1, v));
        while (!stack.isEmpty()) {
            Node latest = stack.pop();
            boolean[] visit = latest.visit;
            visit[latest.r * c + latest.c] = true;
            int sR = latest.r + DIR[latest.dir][0];
            int sC = latest.c + DIR[latest.dir][1];

            int rD = (latest.dir + 1) % 4;
            int rR = latest.r + DIR[rD][0];
            int rC = latest.c + DIR[rD][1];

            if ((!isInRange(rR, rC, r, c) || visit[rR * c + rC])
                    && (!isInRange(sR, sC, r, c) || visit[sR * c + sC])) {
                // 우아한 경로가 생성되지 않을 경우, 종료한다
                answer++;
                continue;
            }
            if (isInRange(sR, sC, r, c) && !visit[sR * c + sC]) {
                stack.push(new Node(sR, sC, latest.dir, visit.clone()));
            }
            if (isInRange(rR, rC, r, c) && !visit[rR * c + rC]) {
                stack.push(new Node(rR, rC, rD, visit.clone()));
            }
        }
        return answer;
    }

    static boolean isInRange(int r, int c, int totalR, int totalC) {
        return r >= 0 && r < totalR && c >= 0 && c < totalC;
    }

    static class Node {
        int r;
        int c;
        int dir;
        boolean[] visit;

        public Node(int r, int c, int dir, boolean[] visit) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.visit = visit;
        }
    }
}
