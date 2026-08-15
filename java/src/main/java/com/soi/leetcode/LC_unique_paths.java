package com.soi.leetcode;

public class LC_unique_paths {
    public int uniquePaths(int m, int n) {
        int[][] pathCounts = new int[m][n];
        // init
        pathCounts[0][0] = 1;
        for (int i = 1; i < m; i++) {
            pathCounts[i][0] += pathCounts[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            pathCounts[0][i] += pathCounts[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathCounts[i][j] = pathCounts[i - 1][j] + pathCounts[i][j - 1];
            }
        }
        return pathCounts[m - 1][n - 1];
    }
}
