package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_7576 {
    static int[][] pan;
    static int answer;
    static int[][] time;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        pan = new int[m][n];
        time = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int status = scan.nextInt();
                pan[i][j] = status;
                if (status == 1) {
                    time[i][j] = 0;
                } else {
                    time[i][j] = Integer.MAX_VALUE;
                }
            }
        }
//		/
        int[][] bf = time.clone();
        int count = 0;
        while (true) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pan[i][j] == -1)
                        continue;
                    int min = time[i][j];
                    for (int a : new int[]{0, 1, 2, 3}) {
                        if ((i + dx[a] < 0 || i + dx[a] >= pan.length || j + dy[a] < 0 || j + dy[a] >= pan[0].length)
                                || pan[i + dx[a]][j + dy[a]] == -1) {
                            continue;
                        }
                        min = Math.min(min, time[i + dx[a]][j + dy[a]]);
                    }
                    time[i][j] = Math.min(time[i][j], min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1);
                }
            }
            if (notsame(time, bf)) {
                break;
            }
            bf = time;
            count++;
        }

        for (int[] a : time) {
            for (int b : a) {
                System.out.print(b + " | ");
            }
            System.out.println();
        }
        scan.close();
    }

    public static boolean notsame(int[][] a, int[][] b) {
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void ripe(int x, int y, int second, boolean[][] visit) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        time[x][y] = Math.min(time[x][y], second + 1);
        for (int a : new int[]{0, 1, 2, 3}) {
            if ((x + dx[a] < 0 || x + dx[a] >= pan.length || y + dy[a] < 0 || y + dy[a] >= pan[0].length)
                    || pan[x + dx[a]][y + dy[a]] == -1) {
                continue;
            }
            ripe(x + dx[a], y + dy[a], time[x][y], visit);
        }
    }
}
