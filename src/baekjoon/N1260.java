package baekjoon;

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
	}

	/**
	 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �湮�� �� �ִ� ������ ���� ���� ��쿡��
	 * ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
	 */
	public static String dfs(boolean[] visit, String out, int index) {
		String rt = (index + 1) + " ";
		if (visit[index]) {
			return "";
		}
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i] && connect[index][i]) {
				visit[i] = true;
				rt += dfs(visit, out + (i + 1), i);
				continue;
			}
		}
		return rt;
	}
}
