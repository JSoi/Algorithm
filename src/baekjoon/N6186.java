package baekjoon;

import java.util.Scanner;

public class N6186 {
	static char l[][];
	static boolean v[][];
	static int count = 0;
	static int r;
	static int c;
	final static int dx[] = { -1, 0, 1, 0 };
	final static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		l = new char[r][c];
		v = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String line = scan.next();
			for (int j = 0; j < c; j++) {
				l[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!v[i][j] && l[i][j] == '#') {
					dfs(i, j);
					count++;
				}
			}
		}
		scan.close();
		// System.out.println(count);
	}

	public static void dfs(int x, int y) {
		v[x][y] = true;
		System.out.println("x : " + x + " y : " + y);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c)
				continue;
			if (!v[nx][ny] && l[nx][ny] == '#')
				dfs(nx, ny);
		}
	}

}
