package com.soi.programmers;

public class POG_92345 {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final int MAX = Integer.MAX_VALUE;
    private int[][] board;

    public static void main(String[] args) {
        POG_92345 pog = new POG_92345();
        int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        int result = pog.solution(board, aloc, bloc);
        System.out.println(result);
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        // board 상태, 현재 위치
        // 무조건 승리할 수 있는 위치
        // 승리를 연장할 수 있는 위치
        return dfs(aloc, bloc, 0);
    }

    private int dfs(int[] aPos, int[] bPos, int moveCount) {
        int aX = aPos[0], aY = aPos[1];
        int bX = bPos[0], bY = bPos[1];
        if (board[aX][aY] == 0) return moveCount; // game end
        int result = MAX;
        for (int[] d : dir) {
            int nextX = aX + d[0], nextY = aY + d[1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || board[nextX][nextY] == 0) continue;
            board[aX][aY] = 0;
            result = Math.min(result, dfs(new int[]{bX, bY}, new int[]{nextX, nextY}, moveCount + 1));
            board[aX][aY] = 1;
        }
        if (result == MAX) return moveCount;
        return result;
    }
}
