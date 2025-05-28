package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] VE = br.readLine().split(" ");
            int V = Integer.parseInt(VE[0]);
            int E = Integer.parseInt(VE[1]);
            int[][] conn = new int[E][2];
            for (int j = 0; j < E; j++) {
                String[] s = br.readLine().split(" ");
                conn[j][0] = Integer.parseInt(s[0]);
                conn[j][1] = Integer.parseInt(s[1]);
            }
            Test test = new Test(V, conn);
            bw.append(test.isBinary() ? "YES" : "NO").append("\n");
        }
        bw.flush();
    }

    private static class Test {
        int V;
        ArrayList<Integer>[] conn;

        public Test(int V, int[][] c) {
            this.V = V;
            conn = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                conn[i] = new ArrayList<>();
            }
            for (int[] i : c) {
                conn[i[0]].add(i[1]);
                conn[i[1]].add(i[0]);
            }
        }

        public boolean isBinary() {
            int[] side = new int[V + 1];
            Arrays.fill(side, -1);
            for (int i = 1; i <= V; i++) {
                if (side[i] != -1) continue;
                if (!dfs(i, side)) return false;
            }
            return true;
        }

        private boolean dfs(int start, int[] color) {
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            color[start] = 0;
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                for (int neighbor : conn[curr]) {
                    if (color[neighbor] == color[curr]) {
                        return false;
                    }
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[curr];
                        stack.push(neighbor);
                    }
                }
            }
            return true;
        }
    }
}
