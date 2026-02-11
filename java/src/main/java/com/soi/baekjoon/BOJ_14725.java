package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14725 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node("", -1);
        int infoCount = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < infoCount; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(tok.nextToken());
            Node target = root;
            for (int j = 0; j < c; j++) {
                String targetStr = tok.nextToken();
                target = target.addChildren(targetStr);
            }
        }
        root.print();
        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        String name;
        int depth;
        List<Node> children;

        public Node(String name, int depth) {
            this.name = name;
            this.depth = depth;
            this.children = new ArrayList<>();
        }

        @Override
        public int compareTo(Node node) {
            return this.name.compareTo(node.name);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        public Node addChildren(String targetStr) {
            for (Node child : children) {
                if (child.name.equals(targetStr)) {
                    return child;
                }
            }
            Node newNode = new Node(targetStr, this.depth + 1);
            children.add(newNode);
            return newNode;
        }

        public void print() {
            if (this.depth >= 0) {
                sb.append("--".repeat(this.depth)).append(this.name).append('\n');
            }
            Collections.sort(children);
            for (Node child : children) {
                child.print();
            }
        }
    }
}
