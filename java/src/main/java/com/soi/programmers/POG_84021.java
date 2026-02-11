package com.soi.programmers;

import java.util.*;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/84021">퍼즐 조각 채우기</a>
 */
public class POG_84021 {
    private static final int[][] MOVE = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int row;
    private static int col;
    private static boolean[] visit;
    private static boolean[][] map;

    public static void main(String[] args) {
        int[][] gameBoard = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(solution(gameBoard, table));
    }

    public static int solution(int[][] gameBoard, int[][] table) {
        row = gameBoard.length;
        col = gameBoard[0].length;
        // board
        map = toBoolArr(gameBoard, false);
        List<boolean[][]> gameboardPiece = getPieces();
        // puzzle
        map = toBoolArr(table, true);
        List<boolean[][]> tablePiece = getPieces();

        int answer = 0;
        for (boolean[][] gb : gameboardPiece) {
            Iterator<boolean[][]> ti = tablePiece.iterator();
            while (ti.hasNext()) {
                boolean[][] tablePuzzle = ti.next();
                if (doesFit(gb, tablePuzzle)) {
                    ti.remove();
                    answer += count(gb);
                    break;
                }
            }
        }
        return answer;
    }

    private static ArrayList<boolean[][]> getPieces() {
        visit = new boolean[row * col];
        ArrayList<boolean[][]> tablePiece = new ArrayList<>();
        for (int i = 0; i < row; i++) { // gameboard
            for (int j = 0; j < col; j++) {
                if (visit[i * col + j] || !map[i][j]) { // gb
                    continue;
                }
                Set<Integer> set = positionSearch(i * col + j);
                boolean[][] eachPuzzle = toArr(set);
                tablePiece.add(eachPuzzle);
            }
        }
        return tablePiece;
    }

    public static boolean[][] toBoolArr(int[][] input, boolean flag) {
        boolean[][] arr = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = input[i][j] == (flag ? 1 : 0);
            }
        }
        return arr;
    }

    private static Set<Integer> positionSearch(int pos) {
        visit[pos] = true;
        Set<Integer> visitSet = new HashSet<>();
        visitSet.add(pos);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int cR = curr / col;
            int cC = curr % col;
            for (int[] m : MOVE) {
                int r = cR + m[0];
                int c = cC + m[1];
                if (r < 0 || r >= row || c < 0 || c >= col || visit[r * col + c] || !map[r][c]) {
                    continue;
                }
                int nexPos = r * col + c;
                queue.offer(nexPos);
                visitSet.add(nexPos);
                visit[r * col + c] = true;
            }
        }
        return visitSet;
    }

    private static boolean[][] toArr(Set<Integer> set) {
        int minR = set.stream().map(a -> a / col).min(Integer::compareTo).orElse(0);
        int maxR = set.stream().map(a -> a / col).max(Integer::compareTo).orElse(0);
        int minC = set.stream().map(a -> a % col).min(Integer::compareTo).orElse(0);
        int maxC = set.stream().map(a -> a % col).max(Integer::compareTo).orElse(0);
        boolean[][] arr = new boolean[maxR - minR + 1][maxC - minC + 1];
        for (Integer i : set) {
            int cR = i / col - minR;
            int cC = i % col - minC;
            arr[cR][cC] = true;
        }
        return arr;
    }

    private static boolean[][] rotate(boolean[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        boolean[][] rotated = new boolean[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotated[j][row - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    private static boolean doesFit(boolean[][] a, boolean[][] b) {
        if ((a.length != b.length && a[0].length != b[0].length) &&
                (a.length != b[0].length && a[0].length != b.length)
        ) {
            return false;
        }
        if (isSame(a, b)) {
            return true;
        }
        boolean[][] curr = b.clone();
        for (int i = 0; i < 4; i++) {
            if (isSame(a, curr)) {
                return true;
            }
            curr = rotate(curr);
        }
        return false;
    }

    private static boolean isSame(boolean[][] a, boolean[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int count(boolean[][] a) {
        int count = 0;
        for (boolean[] aa : a) {
            for (boolean bb : aa) {
                if (bb) {
                    count++;
                }
            }
        }
        return count;
    }
}
