package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1520 {
    static int row, col;
    static int map[][];
    static int answer;
    static boolean[][] visit;
    static final int[] dc = {0, 0, -1, 1};
    static final int[] dr = {1, -1, 0, 0};
    static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        String fLine = buf.readLine();
        row = Integer.parseInt(fLine.split(" ")[0]);
        col = Integer.parseInt(fLine.split(" ")[1]);
        map = new int[row][col];
        visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String thisLine = buf.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(thisLine.split(" ")[j]);
            }
        }

    }

    static void travel(int targetR, int targetC) {
        if (targetR == map.length - 1 || targetC == map[0].length - 1) {
            answer++;
            return;
        }
        visit[targetR][targetC] = true;
        for (int m = 0; m < 4; m++) {
            int nextR = targetR + dr[m];
            int nextC = targetC + dc[m];
            if (nextC < 0 || nextC >= map[0].length || nextR < 0 || nextR >= map.length
                    || map[nextR][nextC] >= map[targetR][targetC]) {
                continue;
            }
            travel(nextR, nextC);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        travel(0, 0);
        System.out.println(answer);
    }
}
