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
        Collections.sort(nodeList);

        Node rootNode = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            Node child = nodeList.get(i);
            for (int j = 0; j < i; j++) {
                Node parent = nodeList.get(j);
                boolean isLeft = parent.x > child.x;
                if (parent.checkChild(child) && (isLeft ? parent.leftChild == null : parent.rightChild == null)) {
                    child.addParent(parent, isLeft);
                    break;
                }
            }
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

        public boolean checkChild(Node child) {
            if (child.y > this.y) {
                return false;
            }
            if (this.leftChild != null && this.rightChild != null) {
                return false;
            }
            if (this.parent == null) {
                return this.y > child.y;
            }
            return this.x < this.parent.x ? child.x < this.parent.x : child.x > this.parent.x;
        }

        public void addChild(Node child, boolean left) {
            if (left) {
                this.leftChild = child;
            } else {
                this.rightChild = child;
            }
        }

        public void addParent(Node parent, boolean left) {
            this.parent = parent;
            this.parent.addChild(this, left);
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
