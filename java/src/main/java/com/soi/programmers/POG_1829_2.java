package com.soi.programmers;

import java.util.Stack;

public class POG_1829_2 {
    static Stack<Integer> sx = new Stack<Integer>();
    static Stack<Integer> sy = new Stack<Integer>();
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        int[] ans = solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1},
                {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println("area count : " + ans[0]);
        System.out.println("maxSizeOfOneArea : " + ans[1]);

    }

    public static int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        int[] answer = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (!visit[i][j] & picture[i][j] != 0) {
                    go(i, j);
                    count++;
                    answer[0]++;
                }
                while (!sx.empty()) {

                    int x = sx.pop();
                    int y = sy.pop();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {

                            continue;
                        }
                        if (picture[nx][ny] != picture[x][y] || visit[nx][ny]) {

                            continue;
                        }

                        go(nx, ny);
                        count++;
                    }
                }
                answer[1] = Math.max(answer[1], count);
            }
        }
        return answer;
    }

    public static void go(int x, int y) {
        sx.add(x);
        sy.add(y);
        visit[x][y] = true;
    }
}
