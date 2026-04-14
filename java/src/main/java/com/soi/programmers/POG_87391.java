package com.soi.programmers;

public class POG_87391 {
    public static void main(String[] args) {
        long solution = solution(2, 2, 0, 0, new int[][]{{2, 1}, {0, 1}, {1, 1}, {0, 1}, {2, 1}});
        long solution2 = solution(2, 5, 0, 1, new int[][]{{3, 1}, {2, 2}, {1, 1}, {2, 3}, {0, 1}, {2, 1}});
        System.out.println("solution2 = " + solution);
        System.out.println("solution2 = " + solution2);
    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {
        long top = x;
        long bottom = x;
        long left = y;
        long right = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int dist = queries[i][1];

            if (dir == 0) { // 역방향으로 변경 l->r
                if (left != 0) left += dist;
                right = Math.min(right + dist, m - 1);
            }
            else if (dir == 1) { // r->l
                if (right != m - 1) right -= dist;
                left = Math.max(left - dist, 0);
            }
            else if (dir == 2) { // u->d
                if (top != 0) top += dist;
                bottom = Math.min(bottom + dist, n - 1);
            }
            else if (dir == 3) { // d->u
                if (bottom != n - 1) bottom -= dist;
                top = Math.max(top - dist, 0);
            }
            if (top > bottom || left > right) {
                return 0;
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
