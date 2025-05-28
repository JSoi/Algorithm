package com.soi.programmers;

public class L12905 {
	/*
	 * 1�� 0�� ä���� ǥ(board)�� �ֽ��ϴ�. ǥ 1ĭ�� 1 x 1 �� ���簢������ �̷���� �ֽ��ϴ�. ǥ���� 1�� �̷���� ���� ū
	 * ���簢���� ã�� ���̸� return �ϴ� solution �Լ��� �ϼ��� �ּ���. (��, ���簢���̶� �࿡ ������ ���簢���� ���մϴ�.)
	 */

	static int myBoard[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(solution(test));
	}

	// �簢���� �̷������ ���� ���� : ���� ��,��,�ϼ� �αٿ����� ���� �����ؾߵȴ�.
	public static int solution(int[][] board) {
		int answer = board[0][0];
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					int ans = Math.min(board[i - 1][j], board[i][j - 1]);
					ans = Math.min(ans, board[i - 1][j - 1]) + 1;
					board[i][j] = ans; // ���� �� �ִ� ���簢�� ���� ����
					// ���� �ݴ�� �ߴ� �� ����
					answer = Math.max(ans, answer);
				}
			}
		}
		return answer * answer;
	}
}
