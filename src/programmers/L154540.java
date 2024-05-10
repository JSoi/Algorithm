package programmers;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154540">무인도 여행</a>
 */
public class L154540 {
    public int[] solution(String[] maps) {
        ArrayList<Integer> answerList = new ArrayList<>();

        final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        for (int h = 0; h < maps.length; h++) {
            for (int v = 0; v < maps[0].length(); v++) {
                if (maps[h].charAt(v) == 'X' || visit[h][v]) {
                    continue;
                }
                int landSurvivalDay = 0;
                Stack<Node> landStack = new Stack<>();
                landStack.push(new Node(h, v, maps[h].charAt(v) - '0'));
                while (!landStack.isEmpty()) {
                    Node node = landStack.pop();
                    visit[node.h][node.v] = true;
                    landSurvivalDay += node.count;
                    Arrays.stream(move).forEach(m -> {
                        int nextH = node.h + m[1];
                        int nextV = node.v + m[0];
                        if (nextV < 0 || nextH < 0 || nextV >= maps[0].length() || nextH >= maps.length) {
                            return;
                        }
                        if (maps[nextH].charAt(nextV) == 'X' || visit[nextH][nextV]) {
                            return;
                        }
                        visit[nextH][nextV] = true;
                        landStack.push(new Node(nextH, nextV, maps[nextH].charAt(nextV) - '0'));
                    });

                }
                answerList.add(landSurvivalDay);
            }
        }
        if (answerList.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answerList);
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static class Node {
        int h;
        int v;
        int count;

        public Node(int h, int v, int count) {
            this.v = v;
            this.h = h;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        L154540 l154540 = new L154540();
        System.out.println(Arrays.toString(l154540.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1" })));
    }
}
