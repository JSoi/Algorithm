package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class N2583 {
    private static final int[][] movement = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int[][] map = new int[r][c];
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int l = 0; l < k; l++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fillArea(map, line[1], line[0], line[3], line[2]);
        }
        int rectangleCount = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {
                    continue;
                }
                int dimension = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                map[i][j] = rectangleCount;
                while (!stack.isEmpty()) {
                    int[] latest = stack.pop();
                    dimension++;
                    for (int[] m : movement) {
                        int nR = latest[0] + m[0];
                        int nC = latest[1] + m[1];
                        if (nR < 0 || nR >= r || nC < 0 || nC >= c || map[nR][nC] != 0) {
                            continue;
                        }
                        map[nR][nC] = rectangleCount;
                        stack.push(new int[]{nR, nC});
                    }
                }
                rectangleCount++;
                answerList.add(dimension);
            }
        }
        System.out.println(rectangleCount - 1);
        System.out.println(answerList.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void fillArea(int[][] map, int r1, int c1, int r2, int c2) {
        for (int r = Math.min(r1, r2); r < Math.max(r1, r2); r++) {
            for (int c = Math.min(c1, c2); c < Math.max(c1, c2); c++) {
                map[r][c] = -1;
            }
        }
    }
}
