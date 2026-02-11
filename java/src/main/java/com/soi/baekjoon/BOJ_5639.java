package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    private static BufferedReader br;
    private static Node tree;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        tree = new Node(Integer.parseInt(br.readLine()));
        while ((input = br.readLine()) != null) {
            tree.add(Integer.parseInt(input));
        }
        System.out.print(postPrint(tree));
    }

    private static String postPrint(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return "";
        }
        if (node.left != null) {
            sb.append(postPrint(node.left));
        }
        if (node.right != null) {
            sb.append(postPrint(node.right));
        }
        sb.append(node.value).append("\n");
        return sb.toString();
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public void add(int value) {
            if (this.value < value) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);

                }
            } else {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            }
        }
    }
}
