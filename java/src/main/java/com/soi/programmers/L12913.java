package com.soi.programmers;

public class L12913 {
	/**
	 * �����Ա� ������ �Ϸ��� �մϴ�. �����Ա� ������ ��(land)�� �� N�� 4���� �̷���� �ְ�, ��� ĭ���� ������ ���� �ֽ��ϴ�.
	 * 1����� ���� ������ �� �྿ ������ ��, �� ���� 4ĭ �� �� ĭ�� �����鼭 �����;� �մϴ�. ��, �����Ա� ���ӿ��� �� �྿ ������
	 * ��, ���� ���� �����ؼ� ���� �� ���� Ư�� ��Ģ�� �ֽ��ϴ�.
	 */
	// ��ͷ� �ִ밪 ���ϴ°� �ƴα�? ����;
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

	// ó���� �����Ϸ��� �ߴ� ��ͷε� Ǯ��� ^_^
	static int solution2(int[][] board) {
		return dp(board, 0, -1);
	}

	static int dp(int[][] board, int row, int bf) {
		if (row >= board.length)
			return 0;
		int answer = 0;
		for (int i = 0; i < board[0].length; i++) {
			if (i != bf) {
				// Max�� ���� �Ǵ� ��..
				answer = Math.max(dp(board, row + 1, i) + board[row][i], answer);
			}
		}
		return answer;
	}

}
