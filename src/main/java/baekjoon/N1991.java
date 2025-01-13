package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        Tree[] trees = new Tree['Z' - 'A' + 1];
        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            trees[i] = new Tree((char) ('A' + i));
        }
        for (int i = 0; i < line; i++) {
            String[] input = br.readLine().split(" ");
            char alpha = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            if (left != '.') trees[alpha - 'A'].addChild(trees[left - 'A'], true);
            if (right != '.') trees[alpha - 'A'].addChild(trees[right - 'A'], false);
        }
        // tree 정리
        System.out.println(preOrder(trees[0]));
        System.out.println(midOrder(trees[0]));
        System.out.println(lastOrder(trees[0]));

    }

    static String midOrder(Tree current) {
        if (current == null) {
            return "";
        }
        return midOrder(current.left) + current.alphabet + midOrder(current.right);
    }

    static String preOrder(Tree current) {
        if (current == null) {
            return "";
        }
        return current.alphabet + preOrder(current.left) + preOrder(current.right);
    }

    static String lastOrder(Tree current) {
        if (current == null) {
            return "";
        }
        return lastOrder(current.left) + lastOrder(current.right) + current.alphabet;
    }

    static class Tree {
        char alphabet;
        Tree left;
        Tree right;

        public Tree(char alphabet) {
            this.alphabet = alphabet;
        }

        void addChild(Tree child, boolean isLeft) {
            if (isLeft) {
                this.left = child;
            } else {
                this.right = child;
            }
        }
    }
}
