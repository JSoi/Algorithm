package com.soi.programmers;

public class L17679 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4, 5, new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" }));
	}

	public static int solution(int m, int n, String[] board) {
		char[][] boardC = new char[m][n];
		for (int i = 0; i < m; i++) {// 0�� ����
			for (int j = 0; j < n; j++) {// 0�� ����
				boardC[i][j] = board[i].charAt(j);
			}
		}
		int answer = sol(m, n, boardC);
		return answer;
	}

	public static int sol(int m, int n, char[][] boardC) {
		int answer = 0;
		int myb[][] = new int[m][n];
		while (true) {
			int smallanswer = 0;
			boolean visit[][] = new boolean[m][n];
			for (int i = 0; i < m; i++) {// 0�� ����
				for (int j = 0; j < n; j++) {// 0�� ����
					myb[i][j] = (boardC[i][j] == ' ') ? 0 : 1;
				}
			}
			for (int l = 1; l < m; l++) {
				for (int k = 1; k < n; k++) {
					char c = boardC[l][k];
					if (c != ' ' && c == boardC[l - 1][k] && c == boardC[l][k - 1] && c == boardC[l - 1][k - 1]) {
						myb[l][k] += (myb[l - 1][k] + myb[l][k - 1] + myb[l - 1][k - 1]);
						myb[l - 1][k] = myb[l - 1][k - 1] = myb[l][k - 1] = 0;
						visit[l][k] = visit[l - 1][k] = visit[l - 1][k - 1] = visit[l][k - 1] = true;
					}
				}
			}
			for (int l = 0; l < m; l++) {
				for (int k = 0; k < n; k++) {
					if (visit[l][k]) {
						smallanswer += myb[l][k];
						boardC[l][k] = ' ';
					}
				}
			}
			if (smallanswer == 0) {
				break;
			}
			answer += smallanswer;
			boardC = collapse(boardC, m);
		}
		return answer;

	}

	// �� �������� �Լ�
	static char[][] collapse(char[][] input, int m) {
		for (int j = 0; j < input[0].length; j++) {
			String line = "";
			for (int i = 0; i < m; i++) {
				if (input[i][j] != ' ') {
					line += input[i][j];
				}
			}
			int lineIndex = 0;
			for (int i = 0; i < m; i++) {
				if (i < m - line.length()) {
					input[i][j] = ' ';
				} else {
					input[i][j] = line.charAt(lineIndex++);
				}
			}
		}
		return input;
	}

	static void printArrC(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void printArrI(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
