package com.soi.programmers;

import java.util.Arrays;

public class L92343 {
    static boolean[] visit;
    static int answer;
    static int[][] tree;
    static int[] lambOrWolf;

    public static void main(String[] args) {
        int answer = new L92343().solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{
                        {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7},
                        {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
                }
        );
        System.out.println(answer);
    }

    public int solution(int[] info, int[][] edges) {
        // ㅇㅣ진트리
        lambOrWolf = info;
        tree = new int[info.length][2];
        visit = new boolean[info.length];
        for (int[] t : tree) {
            Arrays.fill(t, -1);
        }
        for (int[] e : edges) {
            int parent = e[0];
            int child = e[1];
            if (tree[parent][0] == -1) {
                tree[parent][0] = child;
            } else {
                tree[parent][1] = child;
            }
        }
        answer = 0;
        visit[0] = true;
        visit(0, 1);
        return answer;
    }

    private static void visit(int wolf, int sheep) {
        if (wolf == sheep) {
            return;
        }
        answer = Math.max(answer, sheep);
        for (int treeIndex = 0; treeIndex < tree.length; treeIndex++) {
            if (!visit[treeIndex]) {
                continue;
            }
            for (int dir = 0; dir < 2; dir++) {
                int d = tree[treeIndex][dir];
                if (d != -1 && !visit[d]) { // left
                    boolean isLamb = lambOrWolf[d] == 0;
                    visit[d] = true;
                    visit(wolf + (isLamb ? 0 : 1), sheep + (isLamb ? 1 : 0));
                    visit[d] = false;
                }
            }
        }
    }
}
