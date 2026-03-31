package com.soi.programmers;

import java.util.function.Function;

public class POG_468378 {
    public static void main(String[] args) {
        POG_468378 sample = new POG_468378();
        int answer1 = sample.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 55, guess -> judge(3, guess));
        System.out.println(answer1);
    }

    private static int judge(int secret, int guess) {
        if (secret == guess) return 0;
        return secret < guess ? -1 : 1;
    }

    private static int[][] minCost;
    private static int[][] pos;

    public static int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        minCost = new int[n][n];
        pos = new int[n][n];
        for (int i = 0; i < n; i++) {
            minCost[i][i] = depth[i];
            pos[i][i] = i;
        }
        // init dp
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (l == r) {
                    minCost[l][r] = depth[l];
                    pos[l][r] = l;
                    continue;
                }
                minCost[l][r] = Integer.MAX_VALUE;
                for (int k = l; k <= r; k++) {
                    int left = (k > l) ? minCost[l][k - 1] : 0;
                    int right = (k < r) ? minCost[k + 1][r] : 0;
                    int cur = depth[k] + Math.max(left, right);
                    if (cur < minCost[l][r]) {
                        minCost[l][r] = cur;
                        pos[l][r] = k;
                    }
                }
            }
        }
        int start = 0;
        int end = n - 1;
        while (true) {
            int candidate = pos[start][end];
            System.out.println("candidate = " + candidate);
            int result = excavate.apply(candidate + 1);
            if (result == 0) {
                return candidate + 1;
            }
            if (result < 0) { // search from left
                end = candidate - 1;
            } else {
                start = candidate + 1;
            }
        }
    }
}
