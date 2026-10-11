package com.soi.leetcode;

public class LC_unique_binary_search_trees {
    public static void main(String[] args) {
        LC_unique_binary_search_trees solution = new LC_unique_binary_search_trees();
        int n = 1; // Example input
        int result = solution.numTrees(n);
        System.out.println("Number of unique BSTs for n = " + n + ": " + result);
    }

    private boolean[] used;

    public int numTrees(int n) {
        used = new boolean[n + 1];
        return findBST(1, n);
    }

    private int findBST(int from, int to) {
        // end condition
        if (from == to)
            return 1;
        int bstCount = 0;
        for (int r = from; r <= to; r++) {
            if (used[r])
                continue;
            used[r] = true;
            if (r == from) {
                bstCount += findBST(from + 1, to);
            } else if (r == to) {
                bstCount += findBST(from, to - 1);
            } else {
                bstCount += findBST(from, r - 1) * findBST(r + 1, to);
            }
            used[r] = false;
        }
        return bstCount;
    }
}
