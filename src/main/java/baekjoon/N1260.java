package baekjoon;

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
	 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는
	 * 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
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
