package com.soi.baekjoon;

import java.io.IOException;
import java.util.*;

public class BOJ_6416 {
    private static final String ISTREE = "Case %d is a tree.";
    private static final String ISNOTTREE = "Case %d is not a tree.";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        int caseCount = 1;
        while (true) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if (u == -1 || v == -1) {
                break;
            }
            if (u == 0 && v == 0) {
                if (isTree(list)) {
                    System.out.printf((ISTREE) + "%n", caseCount);
                } else {
                    System.out.printf((ISNOTTREE) + "%n", caseCount);
                }
                caseCount++;
                list.clear();
            } else {
                list.add(new int[]{u, v});
            }
        }
    }

    static boolean isTree(List<int[]> list) {
        if (list.isEmpty()) {
            return true;
        }
        HashMap<Integer, Integer> treeMap = new HashMap<>();
        HashSet<Integer> allNodes = new HashSet<>();
        HashSet<Integer> tos = new HashSet<>();
        for (int[] l : list) {
            int from = l[0] - 1;
            int to = l[1] - 1;
            allNodes.add(from);
            allNodes.add(to);
            if (tos.contains(to)) {
                return false;
            }
            tos.add(to);
            treeMap.put(from, to);
        }
        int[] rootCandidates = treeMap.keySet().stream()
                .filter(k -> !tos.contains(k)).mapToInt(Integer::valueOf).toArray();
        return rootCandidates.length == 1;
    }
}
