package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        Tree[] trees = new Tree[ppl];
        Tree root = new Tree(0);
        trees[0] = root;
        tok.nextToken();
        for (int i = 1; i < ppl; i++) {
            int targetRoot = Integer.parseInt(tok.nextToken());
            trees[i] = new Tree(i);
            trees[targetRoot].addChild(trees[i]);
        }
        System.out.println(call(root));

    }

    private static int call(Tree tree) {
        if (tree.isLeaf()) {
            return 0;
        }
        int answer = 0;
        int subTreeStartTime = 1;
        PriorityQueue<Integer> time = new PriorityQueue<>(Comparator.reverseOrder());
        for (Tree child : tree.children) {
            time.offer(call(child));
        }
        while (!time.isEmpty()) {
            answer = Math.max(answer, time.poll() + subTreeStartTime++);
        }
        return answer;
    }

    static class Tree {
        int index;
        Set<Tree> children;

        public Tree(int index) {
            this.index = index;
            children = new HashSet<>();
        }

        public void addChild(Tree child) {
            children.add(child);
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }
    }
}
