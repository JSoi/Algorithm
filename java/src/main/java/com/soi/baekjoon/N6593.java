package com.soi.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593 {
    private static boolean[][][] isWall;
    private static int r, c, h;
    private static int[] start, end;
    private static final int[][] movement = new int[][]{{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!(line = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(line, " ");
            h = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            isWall = new boolean[r][c][h];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < r; j++) {
                    String row = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char cc = row.charAt(k);
                        if (cc == 'S') {
                            start = new int[]{j, k, i};
                        } else if (cc == 'E') {
                            end = new int[]{j, k, i};
                        }
                        isWall[j][k][i] = cc == '#';
                    }
                }
                br.readLine();
            }
            int escapeTime = escape();
            if (escapeTime == -1) {
                bw.write("Trapped!");
            } else {
                bw.write("Escaped in " + escapeTime + " minute(s).");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int escape() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], start[2], 0});
        boolean[][][] visited = new boolean[r][c][h];
        visited[start[0]][start[1]][start[2]] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == end[0] && curr[1] == end[1] && curr[2] == end[2]) {
                return curr[3];
            }
            for (int[] m : movement) {
                int x = curr[0] + m[0];
                int y = curr[1] + m[1];
                int z = curr[2] + m[2];
                if (!inRange(x, y, z) || visited[x][y][z] || isWall[x][y][z]) {
                    continue;
                }
                visited[x][y][z] = true;
                queue.offer(new int[]{x, y, z, curr[3] + 1});
            }
        }
        return -1;
    }

    private static boolean inRange(int rr, int cc, int hh) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c && hh >= 0 && hh < h;
    }
}
