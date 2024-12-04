package programmers;

import java.util.*;

public class L42892 {
    public static void main(String[] args) {
        int[][] solution = new L42892().solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
        Arrays.stream(solution).forEach(s -> System.out.println(Arrays.toString(s)));
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new LinkedList<>();
        int idx = 0;
        for (int[] n : nodeinfo) {
            nodeList.add(new Node(n[0], n[1], idx++));
        }
        nodeList.sort((n1, n2) -> n2.y - n1.y == 0 ? n1.x - n2.x : n2.y - n1.y);
        Node rootNode = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            rootNode.addChild(nodeList.get(i));
        }
        return new int[][]{rootNode.preorderTraversal(), rootNode.postorderTraversal()};
    }

    static class Node implements Comparable<Node> {
        int x, y, index;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public void addChild(Node child) {
            if (this.x > child.x) {
                if (this.leftChild == null) {
                    this.leftChild = child;
                    child.parent = this;
                } else {
                    this.leftChild.addChild(child);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = child;
                    rightChild.parent = this;
                } else {
                    this.rightChild.addChild(child);
                }
            }
        }

        public void addChild(Node child, boolean left) {
            if (left) {
                this.leftChild = child;
            } else {
                this.rightChild = child;
            }
        }


        public int[] preorderTraversal() {
            Queue<Integer> queue = new LinkedList<>();
            preorderTraversal(queue, this);
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void preorderTraversal(Queue<Integer> queue, Node node) {
            if (node == null) return;
            queue.add(node.index + 1);
            preorderTraversal(queue, node.leftChild);
            preorderTraversal(queue, node.rightChild);
        }

        public int[] postorderTraversal() {
            Queue<Integer> queue = new LinkedList<>();
            postorderTraversal(queue, this);
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void postorderTraversal(Queue<Integer> queue, Node node) {
            if (node == null) return;
            postorderTraversal(queue, node.leftChild);
            postorderTraversal(queue, node.rightChild);
            queue.add(node.index + 1);
        }

        @Override
        public int compareTo(Node node) {
            return this.y == node.y ? this.x - node.y : node.y - this.y;
        }
    }
}
