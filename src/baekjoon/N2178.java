package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N2178 {
    static boolean[][] road;
    static boolean[][] visit;
    static int[][] rv;

    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, 1, -1};

    static int n, m;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fl = br.readLine();
        n = Integer.parseInt(fl.split(" ")[0]);
        m = Integer.parseInt(fl.split(" ")[1]);
        road = new boolean[n][m];
        visit = new boolean[n][m];
        rv = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                road[i][j] = line.charAt(j) == '1';
                rv[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        rv[0][0] = 0;
        bfs();
        System.out.println(rv[n - 1][m - 1] + 1);
    }

    static void bfs() {
        Queue<Integer> qX = new LinkedList<>();
        Queue<Integer> qY = new LinkedList<>();
        qX.offer(0);
        qY.offer(0);
        visit[0][0] = true;
        while (!qX.isEmpty()) {
            int x = qX.poll();
            int y = qY.poll();
            for (int k = 0; k < 4; k++) {
                if (x + dx[k] < 0 || y + dy[k] < 0 || x + dx[k] >= n || y + dy[k] >= m
                        || !road[x + dx[k]][y + dy[k]] || visit[x + dx[k]][y + dy[k]]) {
                    continue;
                }
                qX.offer(x + dx[k]);
                qY.offer(y + dy[k]);

                visit[x + dx[k]][y + dy[k]] = true;
                rv[x + dx[k]][y + dy[k]] = rv[x][y] + 1;
            }
        }
    }
}
