package programmers;


import tool.Assertions;

public class L250125 {
    public static void main(String[] args) throws Exception {
        String[][] board = new String[][]{
                {"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int solution = new L250125().solution(board, 1, 1);
        Assertions.check(solution, 2);
    }
    final int[][] direction = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for (int[] dir : direction) {
            int nextH = h + dir[0];
            int nextW = w + dir[1];
            if (!isInRange(board, nextH, nextW) || !board[nextH][nextW].equals(board[h][w])) {
                continue;
            }
            answer++;
        }
        return answer;
    }

    private boolean isInRange(String[][] board, int h, int w){
        return h >= 0 && h < board.length && w >= 0 && w < board[0].length;
    }
}
