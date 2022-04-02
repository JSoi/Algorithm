package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1303 {
	static int n, m, blue, white;
	static long count;
	static boolean[][] visit;
	static char[][] map;
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			// �������� ���� ũ�� N, ���� ũ�� M(1 �� N, M �� 100)�� �־�����
			// �� ���� : m �� ���� : n
			n = Integer.parseInt(line.split(" ")[0]);
			m = Integer.parseInt(line.split(" ")[1]);
			map = new char[m][n];
			visit = new boolean[m][n];
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < m; i++) {
			String thisLine = br.readLine();
			map[i] = thisLine.toCharArray();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		solve();
		System.out.println(white + " " + blue);
	}

	static void solve() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count = 1;
				if (visit[i][j]) {
					continue;
				}
				dfs(i, j, map[i][j]);
				if (map[i][j] == 'W') {
					white += count * count;
				} else {
					blue += count * count;
				}
			}
		}
	}

	// �������� ���� ũ�� N, ���� ũ�� M(1 �� N, M �� 100)�� �־�����
	// �� ���� : m �� ���� : n
	static void dfs(int nowX, int nowY, char targetColor) {
		visit[nowX][nowY] = true;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (nowX + dx[x] < 0 || nowX + dx[x] >= m || nowY + dy[y] < 0 || nowY + dy[y] >= n
						|| visit[nowX + dx[x]][nowY + dy[y]] || map[nowX + dx[x]][nowY + dy[y]] != targetColor) {
					continue;
				}
				count++;
				dfs(nowX + dx[x], nowY + dy[y], targetColor);
			}
		}
	}
}
