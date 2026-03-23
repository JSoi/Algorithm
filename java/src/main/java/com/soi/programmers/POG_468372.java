package com.soi.programmers;

public class POG_468372 {
    public static void main(String[] args) {
        System.out.println(solution(0, 10));
        System.out.println(1);
    }

    private static int maxLeafCount = 1;
    private static int distLimit;
    private static int splitLimit;

    public static int solution(int dist_limit, int split_limit) {
        maxLeafCount = 1;
        distLimit = dist_limit;
        splitLimit = split_limit;
        count(1, 1, 0, 1);
        return maxLeafCount;
    }

    private static void count(int lvlDNode, int dNode, int lNode, int split) {
        if (dNode > distLimit) return;
        maxLeafCount = Math.max(maxLeafCount, lNode + lvlDNode); // dNode 또한 조건에 맞지 않으면 leafNode일 수 있음
        for (int child = 2; child <= 3; child++) {
            int nextSplit = split * child;
            if (nextSplit > splitLimit) break;
            int nextNodes = lvlDNode * child; // 다음 뎁스의 dNode
            int nextLvlDNode = Math.min(nextNodes, distLimit - dNode);
            int nextLeaf = lNode + (nextNodes - nextLvlDNode);
            count(nextLvlDNode, dNode + nextLvlDNode, nextLeaf, nextSplit);
        }
    }
}
