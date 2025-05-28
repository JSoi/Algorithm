package com.soi.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1260 {
	static boolean connect[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int start = scan.nextInt();
		connect = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			connect[x][y] = connect[y][x] = true;
		}
		scan.close();
		System.out.println(dfs(new boolean[n], "" + start, start - 1).trim());
		System.out.println(bfs(new boolean[n], start - 1).trim());
	}

	/**
	 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �湮�� �� �ִ� ������ ���� ���� ��쿡��
	 * ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
	 */
	public static String dfs(boolean[] visit, String out, int index) {
		if (visit[index]) {
			return "";
		}
		visit[index] = true;
		String rt = (index + 1) + " ";
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i] && connect[index][i]) {
				rt += dfs(visit, out + (i + 1), i);
				continue;
			}
		}
		return rt;
	}

	public static String bfs(boolean[] visit, int index) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(index);
		String answer = "";
		visit[index] = true;
		while (!q.isEmpty()) {
			int target = q.poll();
			for (int i = 0; i < visit.length; i++) {
				if (!visit[i] && connect[target][i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
			answer += target + 1 + " ";
		}
		return answer;
	}
}
