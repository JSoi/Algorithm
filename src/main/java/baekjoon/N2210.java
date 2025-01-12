package baekjoon;

import java.util.*;

public class N2210 {
    static int[][] map;
    static Set<Integer> visited;
    static final int[][] move = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) {
        visited = new HashSet<>();
        map = new int[5][5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            map[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                go(r, c, 0, "");
            }
        }
        System.out.println(visited.size());
    }

    private static void go(int r, int c, int depth, String value) {
        if (depth == 6) {
            visited.add(Integer.parseInt(value));
            return;
        }
        for (int[] m : move) {
            int nextR = r + m[0];
            int nextC = c + m[1];
            if (nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) {
                continue;
            }
            go(nextR, nextC, depth + 1, value + map[r][c]);
        }
    }

}
