package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1520 {
	static int count;
	static int row, col;
	static int map[][];
	static int length;
	static boolean[][] visit;
	final static int[] dc = { 0, 0, -1, 1 };
	final static int[] dr = { 1, -1, 0, 0 };
	static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

	static void input() throws IOException {
		String fLine = buf.readLine();
		row = Integer.parseInt(fLine.split(" ")[0]);
		col = Integer.parseInt(fLine.split(" ")[1]);
		map = new int[row][col];
		visit = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			String thisLine = buf.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(thisLine.split(" ")[j]);
			}
		}

	}

	static void dfs(int r, int c, int value) {
		System.out.println(r + "/" + c);
		if ((r == row - 1) && (c == col - 1)) {
			length++;
		}
		for (int k = 0; k < 4; k++) {
			if (r + dr[k] < 0 || r + dr[k] >= row || c + dc[k] < 0 || c + dc[k] >= col || visit[r + dr[k]][c + dc[k]]
					|| map[r + dr[k]][c + dc[k]] >= value) {
				continue;
			}
			visit[r][c] = true;
			dfs(r + dr[k], c + dc[k], map[r + dr[k]][c + dc[k]]);
			visit[r][c] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		length = 0;
		dfs(0, 0, map[0][0]);
		System.out.println(length);
	}

}
