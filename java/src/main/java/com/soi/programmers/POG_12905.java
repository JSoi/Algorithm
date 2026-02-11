package com.soi.programmers;

public class POG_12905 {


    static int[][] myBoard;

    public static void main(String[] args) {

        int[][] test = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(solution(test));
    }


    public static int solution(int[][] board) {
        int answer = board[0][0];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int ans = Math.min(board[i - 1][j], board[i][j - 1]);
                    ans = Math.min(ans, board[i - 1][j - 1]) + 1;
                    board[i][j] = ans;

                    answer = Math.max(ans, answer);
                }
            }
        }
        return answer * answer;
    }
}
