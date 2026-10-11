package com.soi.leetcode;

public class LC_minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return findDepth(root);
    }

    private int findDepth(TreeNode tree) {
        if (tree.left == null && tree.right == null)
            return 1;
        int minDepth = Integer.MAX_VALUE;
        if (tree.left != null) {
            minDepth = Math.min(minDepth, 1 + findDepth(tree.left));
        }
        if (tree.right != null) {
            minDepth = Math.min(minDepth, 1 + findDepth(tree.right));
        }
        return minDepth;
    }
}
