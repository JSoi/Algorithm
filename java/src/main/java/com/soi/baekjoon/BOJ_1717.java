package com.soi.baekjoon;

import java.io.*;

public class BOJ_1717 {
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int operation = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            int a = Math.min(x, y);
            int b = Math.max(x, y);
            if (operation == 1) {
                bw.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            } else {
                union(a, b);
            }
        }
        bw.flush();
    }

    static int find(int i) {
        if (nums[i] == i) {
            return i;
        }
        return nums[i] = find(nums[i]);
    }

    static void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        if (iRoot == jRoot) return;
        nums[iRoot] = jRoot;
    }
}
