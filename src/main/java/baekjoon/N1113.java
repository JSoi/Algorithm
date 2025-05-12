package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1113 {
    static int[][] pool;
    static boolean[][] visited;
    static boolean[][] canFill;
    static int row;
    static int col;
    static int answer = 0;
    static final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        init();
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                canFill[i][j] = canFill(i, j);
            }
        }

//        for (boolean[] booleans : canFill) {
//            for (boolean b : booleans) {
//                System.out.print(b ? "O" : "X");
//            }
//            System.out.print("\n");
//        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (!canFill[i][j]) {
                    continue;
                }
                fill(i, j);
                answer += calculate(i, j);
            }
        }
        System.out.println(answer);
    }


    private static void fill(int r, int c) {
        Stack<int[]> stack = new Stack<>();
        int height = Math.min(pool[r - 1][c], pool[r][c - 1]);
        stack.push(new int[]{r, c});
        visited[r][c] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            for (int[] dd : d) {
                int nRow = pop[0] + dd[0];
                int nCol = pop[1] + dd[1];
                if (!isInRange(nRow, nCol) || visited[nRow][nCol]) {
                    continue;
                }
                if (pool[nRow][nCol] <= pool[r][c]) {
                    visited[nRow][nCol] = true;
                    stack.push(new int[]{nRow, nCol});
                } else if (height < pool[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                }
            }
        }
    }

    private static boolean canFill(int r, int c) {
        if (isBorder(r, c)) return false;
        boolean[][] v = new boolean[row][col];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        v[r][c] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            if (isBorder(pop[0], pop[1])) {
                return false;
            }
            for (int[] dd : d) {
                int nRow = pop[0] + dd[0];
                int nCol = pop[1] + dd[1];
                if (!isInRange(nRow, nCol) || v[nRow][nCol]) {
                    continue;
                }
                if (pool[nRow][nCol] <= pool[r][c]) {
                    v[nRow][nCol] = true;
                    stack.push(new int[]{nRow, nCol});
                }
            }
        }
        return true;
    }


    private static int calculate(int r, int c) {
        int wallHeight = Math.min(pool[r - 1][c], pool[r][c - 1]);
        boolean[][] v = new boolean[row][col];

        LinkedList<int[]> queue = new LinkedList<>();
        List<int[]> holes = new ArrayList<>();

        queue.add(new int[]{r, c});
        v[r][c] = true;

        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            holes.add(new int[]{pop[0], pop[1], pool[pop[0]][pop[1]]});
            int minHeight = wallHeight;
            for (int[] dd : d) {
                int nRow = pop[0] + dd[0];
                int nCol = pop[1] + dd[1];
                if (!isInRange(nRow, nCol) || v[nRow][nCol]) {
                    continue;
                }
                if (!canFill[nRow][nCol]) {
                    minHeight = Math.min(minHeight, pool[nRow][nCol]);
                    continue;
                }
                v[nRow][nCol] = true;
                queue.add(new int[]{nRow, nCol});
            }
            wallHeight = minHeight;
        }

        int answer = 0;
        for (int[] h : holes) {
            canFill[h[0]][h[1]] = false;
            answer += wallHeight - h[2];
        }
        return answer;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        visited = new boolean[row][col];
        canFill = new boolean[row][col];
        for (boolean[] cf : canFill) {
            Arrays.fill(cf, true);
        }
        pool = new int[row][col];
        for (int i = 0; i < row; i++) {
            String row = br.readLine();
            for (int j = 0; j < col; j++) {
                pool[i][j] = Integer.parseInt(row.charAt(j) + "");
            }
        }
    }

    private static boolean isInRange(int r, int c) {
        return (r >= 0 && r < row) && (c >= 0 && c < col);
    }

    private static boolean isBorder(int i, int j) {
        return i == 0 || j == 0 || i == row - 1 || j == col - 1;
    }
}
