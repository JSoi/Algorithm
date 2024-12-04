package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L77485 {
    public static void main(String[] args) {
//        int[] solution = new L77485().solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        int[] solution = new L77485().solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        IntStream.range(0, rows * columns).forEach(i -> map[i / columns][i % columns] = i + 1);
        int answerIndex = 0;
        for (int[] query : queries) {
            answer[answerIndex++] = rotate(map, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }
        return answer;
    }

    private int rotate(int[][] map, int r1, int c1, int r2, int c2) {
        int answer = Integer.MAX_VALUE;
        int[][] mapClone = new int[map.length][map[0].length];
        for (int r = 0; r < map.length; r++) {
            mapClone[r] = Arrays.copyOf(map[r], map[0].length);
        }
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (r > r1 && r < r2 && c > c1 && c < c2) {
                    continue;
                }
                answer = Math.min(answer, map[r][c]);
                if ((r == r1 && c == c1) || (r == r1 && c == c2) || (r == r2 && c == c1) || (r == r2 && c == c2)) {
                    continue;
                }
                if (r == r1) { // right
                    map[r][c] = mapClone[r][c - 1];
                } else if (c == c1) {//to up
                    map[r][c] = mapClone[r + 1][c];
                } else if (c == c2) { // down
                    map[r][c] = mapClone[r - 1][c];
                } else if (r == r2) { // left
                    map[r][c] = mapClone[r][c + 1];
                }
            }
        }
        map[r1][c1] = mapClone[r1 + 1][c1];
        map[r2][c1] = mapClone[r2][c1 + 1];
        map[r1][c2] = mapClone[r1][c2 - 1];
        map[r2][c2] = mapClone[r2 - 1][c2];
        return answer;
    }
}
