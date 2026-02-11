package com.soi.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class POG_49189 {

    public static void main(String[] args) {

        Solution49189 sol = new Solution49189();
        System.out.println(
                sol.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
        // 3
    }

}

class Solution49189 {

    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new LinkedList<Integer>();
        int answer = 0;
        boolean[] visit = new boolean[n];
        boolean[][] co = new boolean[n][n];
        for (int[] e : edge) {
            co[e[0] - 1][e[1] - 1] = true;
            co[e[1] - 1][e[0] - 1] = true;
        }

        visit[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int thisLevelSize = q.size();
            int count = thisLevelSize;
            while (count > 0) {
                count--;
                int target = q.poll();
                for (int i = 0; i < n; i++) {
                    if (!visit[i] && co[i][target]) {
                        q.add(i);
                        visit[i] = true;
                    }
                }
            }
            answer = thisLevelSize;
        }

        return answer;
    }

}