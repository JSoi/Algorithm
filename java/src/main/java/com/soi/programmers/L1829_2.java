package com.soi.programmers;

import java.util.Stack;

public class L1829_2 {
	static Stack<Integer> sx = new Stack<Integer>();
	static Stack<Integer> sy = new Stack<Integer>();
	static boolean visit[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[] = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		System.out.println("area count : " + ans[0]);
		System.out.println("maxSizeOfOneArea : " + ans[1]);

	}

	public static int[] solution(int m, int n, int[][] picture) {
		visit = new boolean[m][n];
		int[] answer = new int[2];
		for (int i = 0; i < m; i++) { // picture�� ��� ���鼭 �ش� ���� ������ ����.
			for (int j = 0; j < n; j++) {
				int count = 0; // ������ ���� ����(i,j)
				if (!visit[i][j] & picture[i][j] != 0) { // ���� �ѹ��� �湮���� �ʾҰų�, �������� ���� �ִ� ���
					go(i, j); // ���ÿ� x,y ��ǥ �����ֱ�
					count++; // ���� ���� �ش��ϴ� ���� �� ����
					answer[0]++; // ���� ���� 1 ����
				}
				while (!sx.empty()) {
					// ������ ���� ���� ���� ������ ������� �ȴ�*
					int x = sx.pop(); // ������ x,y ��ǥ ��������
					int y = sy.pop();
					for (int k = 0; k < 4; k++) { // ��,��,��,�� ��� �˻���
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
							// �迭 ������ ������� üũ
							continue;
						}
						if (picture[nx][ny] != picture[x][y] || visit[nx][ny]) {
							// Stack���� pop�� ��ǥ�� ����� ������, �湮�� ������ �˻�
							continue;
						}
						// ���͸� ����ߴٸ� ���ð� �湮 �迭�� ������Ʈ�ϰ�, �ش� ������ ������ 1 �����ش�.
						go(nx, ny);
						count++;
					}
				}
				answer[1] = Math.max(answer[1], count);
			}
		}
		return answer;
	}

	public static void go(int x, int y) {
		sx.add(x);
		sy.add(y);
		visit[x][y] = true;
	}
}
