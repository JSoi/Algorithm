package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1103 {
    private static final int MAX = Integer.MAX_VALUE;
    private static char[][] map;
    private static int answer;
    private static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        map = new char[row][col];
        for (int r = 0; r < row; r++) {
            String line = br.readLine();
            for (int c = 0; c < col; c++) {
                map[r][c] = line.charAt(c);
            }
        }
        boolean[][] visit = new boolean[row][col];
        visit[0][0] = true;
        move(0, 0, 1, visit);
        System.out.println(answer == MAX ? -1 : answer);
    }

    private static void move(int r, int c, int moveCount, boolean[][] visited) {
        // 방문한 곳을 또 방문할 시 무한으로 반복 가능
        if (answer == MAX) {
            return;
        }
        answer = Math.max(answer, moveCount);
        for (int[] m : movement) {
            int offset = (map[r][c] - '0');
            int nR = r + m[0] * offset;
            int nC = c + m[1] * offset;
            if (answer == -1 || nR < 0 || nR >= map.length || nC < 0 || nC >= map[0].length || map[nR][nC] == 'H') {
                continue;
            }
            if (visited[nR][nC]) {
                answer = MAX;
            } else {
                visited[nR][nC] = true;
                move(nR, nC, moveCount + 1, visited);
                visited[nR][nC] = false;
            }
        }
    }
}
