package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.PriorityQueue;

public class L142085 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new L142085().solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}), 5);
        Assertions.check(new L142085().solution(10, 1, new int[]{2, 2, 2, 2, 2, 10}), 6);
    }

    static int[] enemyArr;
    static int answer = 0;

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : enemy) {
            pq.offer(e);
            if (pq.size() <= k) {
                answer++;
                continue;
            }
            if (!pq.isEmpty() && pq.peek() <= n) {
                n -= pq.poll();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

    // Recursion -> RE
    private static void fight(int index, int leftSoldier, int leftSkillCount) {
        if (index >= enemyArr.length || (leftSoldier < enemyArr[index] && leftSkillCount < 1)) {
            return;
        }
        answer = Math.max(answer, index);
        if (leftSkillCount > 0) {
            fight(index + 1, leftSoldier, leftSkillCount - 1);
        }
        if (leftSoldier >= enemyArr[index]) {
            fight(index + 1, leftSoldier - enemyArr[index], leftSkillCount);
        }
    }

}
