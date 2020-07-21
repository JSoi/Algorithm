package programmers;

public class L12905 {
	/*
	 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰
	 * 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
	 */

	static int myBoard[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(solution(test));
	}

	// 사각형이 이루어지기 위한 조건 : 이전 북,서,북서 부근에서의 값을 참고해야된다.
	public static int solution(int[][] board) {
		int answer = board[0][0];
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					int ans = Math.min(board[i - 1][j], board[i][j - 1]);
					ans = Math.min(ans, board[i - 1][j - 1]) + 1;
					board[i][j] = ans; // 만들 수 있는 정사각형 변의 길이
					// 나는 반대로 했던 것 같다
					answer = Math.max(ans, answer);
				}
			}
		}
		return answer * answer;
	}
}
