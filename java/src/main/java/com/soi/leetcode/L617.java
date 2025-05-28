package com.soi.leetcode;

public class L617 {
    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode answer = hap(root1, root2);
        return answer;
    }

    public TreeNode hap(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return r2;
        }
        if (r2 == null) {
            return r1;
        }
        TreeNode left = hap(r1.left, r2.left);
        TreeNode right = hap(r1.right, r2.right);
        return new TreeNode(r1.val + r2.val, left, right);
    }
}
