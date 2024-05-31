package programmers;

import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160585">혼자서 하는 틱택토</a>
 */
public class L160585 {
    public static void main(String[] args) {
        String[] board = {
                "O.X", ".O.", "..X"
        };
        String[] board2 = {
                "OOO", "...", "XXX"
        };
        String[] board3 = {
                "...", ".X.", "..."
        };
        String[] board4 = {
                "OOX", "OXX", "XOX"
        };
        String[] board5 = {"XOX",
                "OXO",
                "XOO"};
        int solution = new L160585().solution(board5);
        System.out.println(solution);
    }

    public int solution(String[] board) {
        int xCount = (int) Arrays.stream(board)
                .flatMapToLong(string -> LongStream.of(string.chars().filter(ch -> ch == 'X').count()))
                .sum();
        int oCount = (int) Arrays.stream(board)
                .flatMapToLong(string -> LongStream.of(string.chars().filter(ch -> ch == 'O').count()))
                .sum();

        int xWinCount = winCount(board, 'X');
        int oWinCount = winCount(board, 'O');
//        System.out.println("xCount = " + xCount + " | oCount = " + oCount + " | xWinCount = " + xWinCount + " | oWinCount = " + oWinCount);
        if (oCount - xCount > 1 || oCount - xCount < 0 || xWinCount > 0 && oWinCount > 0) {
            return 0;
        }
        if ((oWinCount > 0 && oCount != xCount + 1) || (xWinCount > 0 && xCount != oCount)) {
            return 0;
        }
        return 1;
    }

    public int winCount(String[] board, char player) {
        int winCount = 0;
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            if (board[i].chars().allMatch(ch -> ch == player)) {
                winCount++;
            }
            if (Stream.of(0, 1, 2).allMatch(j -> board[j].charAt(finalI) == player)) {
                winCount++;
            }
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            winCount++;
        }
        if (board[2].charAt(0) == player && board[1].charAt(1) == player && board[0].charAt(2) == player) {
            winCount++;
        }
        return winCount;
    }

}

