package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_binary_tree_inorder_traversal {
    List<Integer> answer;

    private static class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        answer.add(node.val);
        inorder(node.right);
    }
}
