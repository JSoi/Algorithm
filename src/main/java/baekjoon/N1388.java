package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];
        char[][] map = new char[row][col];
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (!visit[r][c]) {
                    answer++;
                    travel(map, visit, r, c);
                }
            }
        }
        System.out.println(answer);
    }

    private static void travel(char[][] map, boolean[][] visit, int r, int c) {
        char target = map[r][c];
        visit[r][c] = true;
        if (target == '-') {
            if (c + 1 < map[0].length && map[r][c + 1] == target)
                travel(map, visit, r, c + 1);
        } else {
            if (r + 1 < map.length && map[r + 1][c] == target)
                travel(map, visit, r + 1, c);
        }
    }
}
