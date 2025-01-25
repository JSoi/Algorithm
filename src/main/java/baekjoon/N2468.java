package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2468 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int r = 0; r < n; r++) {
            map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int maxHeight = Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElse(0);
        int answer = 0;
        for (int h = 0; h < maxHeight; h++) {
            answer = Math.max(answer, findIsland(h));
        }
        System.out.println(answer);
    }

    private static int findIsland(int h) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int count = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] > h && !visited[r][c]) {
                    count++;
                    travel(r, c, h, visited);
                }
            }
        }
        return count;
    }

    private static void travel(int r, int c, int h, boolean[][] visited) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
            return;
        }
        if (map[r][c] <= h || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        travel(r + 1, c, h, visited);
        travel(r - 1, c, h, visited);
        travel(r, c + 1, h, visited);
        travel(r, c - 1, h, visited);
    }
}
