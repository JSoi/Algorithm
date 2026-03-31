package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18428 {
    private static int n;
    private static Set<int[]> teachers = new HashSet<>();
    private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                }
            }
        }
        boolean b = backTracking(0, 0);
        System.out.println(b ? "YES" : "NO");
    }

    private static boolean backTracking(int depth, int pos) {
        if (depth >= 3 || pos >= n * n) {
            return isComplete();
        }
        boolean result = false;
        for (int i = pos; i < n * n; i++) {
            int r = i / n;
            int c = i % n;
            if (map[r][c] != 'X') {
                continue;
            }
            map[r][c] = 'O';
            result |= backTracking(depth + 1, i + 1);
            map[r][c] = 'X';
        }
        return result;
    }

    private static boolean isComplete() {
        for (int[] teacherPos : teachers) {
            if (findStudent(teacherPos[0], teacherPos[1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean findStudent(int rr, int cc) {
        for (int[] dd : dir) {
            int distance = 1;
            int nR = dd[0] * distance + rr;
            int nC = dd[1] * distance + cc;
            while (inRange(nR, nC)) {
                if (map[nR][nC] == 'S') {
                    return true;
                } else if (map[nR][nC] == 'O') {
                    break;
                }
                distance++;
                nR = dd[0] * distance + rr;
                nC = dd[1] * distance + cc;
            }
        }
        return false;
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < n && cc >= 0 && cc < n;
    }
}
