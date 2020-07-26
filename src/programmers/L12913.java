package programmers;

public class L12913 {
	/**
	 * 땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
	 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 단, 땅따먹기 게임에는 한 행씩 내려올
	 * 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
	 */
	// 재귀로 최대값 구하는게 아늴까? ㅎㅎ;
	public static void main(String[] args) {
		System.out.println(solution2(new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } }));
		// 16
	}

	static int solution(int[][] land) {
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				land[i][j] += findMax(land, i - 1, j);
			}
		}
		int max = 0;
		for (int j = 0; j < land[0].length; j++) {
			max = Math.max(max, land[land.length - 1][j]);
		}
		return max;
	}

	static int findMax(int[][] land, int row, int k) {
		int max = 0;
		for (int i = 0; i < land[0].length; i++) {
			if (i != k) {
				max = Math.max(max, land[row][i]);
			}
		}
		return max;
	}

	// 처음에 접근하려고 했던 재귀로도 풀어보자 ^_^
	static int solution2(int[][] board) {
		return dp(board, 0, -1);
	}

	static int dp(int[][] board, int row, int bf) {
		if (row >= board.length)
			return 0;
		int answer = 0;
		for (int i = 0; i < board[0].length; i++) {
			if (i != bf) {
				// Max가 들어가야 되는 곳..
				answer = Math.max(dp(board, row + 1, i) + board[row][i], answer);
			}
		}
		return answer;
	}

}
