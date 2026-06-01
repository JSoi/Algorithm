package com.soi.leetcode;

import java.util.Arrays;

public class LC_redunant_connection {
    static class Solution {
        // no graph
        int[] parent;

        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length; // equals to nodes -> if tree, there would be n-1;
            parent = new int[n + 1];
            Arrays.fill(parent, -1);
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int[] e : edges) {
                int a = e[0];
                int b = e[1];
                int aParent = findParent(a);
                int bParent = findParent(b);
                if (aParent == bParent) {
                    return new int[]{a, b};
                }
                union(a, b);
            }
            return new int[]{0, 0};
        }

        int findParent(int child) {
            if (parent[child] == child)
                return child;
            return parent[child] = findParent(parent[child]);
        }

        void union(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            parent[bParent] = aParent;
        }
    }
}
