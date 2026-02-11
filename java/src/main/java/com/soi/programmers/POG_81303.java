package com.soi.programmers;

import java.util.Arrays;
import java.util.Stack;

public class POG_81303 {
    public static void main(String[] args) {
        new POG_81303().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
    }

    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deleteStack = new Stack<>();
        Node root = new Node(0);
        Node node = root;
        Node current = root;
        for (int i = 1; i < n; i++) {
            Node nextNode = new Node(i);
            node.addNextNode(nextNode);
            node = nextNode;
            if (i == k) {
                current = nextNode;
            }
        }

        for (String command : cmd) {
            if (command.equals("C")) {
                deleteStack.push(current);
                current.delete();
                if (current.prev == null) {
                    root = root.next;
                }
                current = (current.next != null) ? current.next : current.prev;

            } else if (command.equals("Z")) {
                Node restored = deleteStack.pop();
                if (restored.prev == null) {
                    root = restored;
                }
                restored.undoDelete();

            } else {
                String[] parts = command.split(" ");
                char action = parts[0].charAt(0);
                int moveSteps = Integer.parseInt(parts[1]);

                if (action == 'U') {
                    while (moveSteps > 0) {
                        current = current.prev;
                        moveSteps--;
                    }
                } else if (action == 'D') {
                    while (moveSteps > 0) {
                        current = current.next;
                        moveSteps--;
                    }
                }
            }
        }
        char[] result = new char[n];
        Arrays.fill(result, 'X');
        Node search = root;
        while (search != null) {
            result[search.value] = 'O';
            search = search.next;
        }
//        System.out.println(new String(result));
        return new String(result);
    }

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public void addNextNode(Node nextNode) {
            this.next = nextNode;
            nextNode.prev = this;
        }

        public void delete() {
            if (this.prev != null) {
                this.prev.next = this.next;
            }
            if (this.next != null) {
                this.next.prev = this.prev;
            }
        }

        public void undoDelete() {
            if (this.prev != null) {
                this.prev.next = this;
            }
            if (this.next != null) {
                this.next.prev = this;
            }
        }
    }
}
