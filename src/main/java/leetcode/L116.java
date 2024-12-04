package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < level; i++) {
                Node node = queue.poll();
                if (node == null) {
                    return root;
                }
                if (i == level - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }

            level *= 2;
            // per level
        }
        return root;
    }
}
