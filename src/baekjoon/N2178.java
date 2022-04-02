package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2178 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fl = br.readLine();
		int n = Integer.parseInt(fl.split(" ")[0]);
		int m = Integer.parseInt(fl.split(" ")[1]);
		boolean[][] road = new boolean[n][m];
		boolean[][] visit = new boolean[n][m];
		int[][] rv = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				road[i][j] = line.charAt(j) == '1' ? true : false;
				rv[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		rv[0][0] = 0;
		visit[0][0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 4; k++) {
					if (i + dx[k] < 0 || j + dy[k] < 0 || i + dx[k] >= n || j + dy[k] >= m
							|| !road[i + dx[k]][j + dy[k]]) {
						continue;
					}
					rv[i + dx[k]][j + dy[k]] = Math.min(rv[i + dx[k]][j + dy[k]], rv[i][j] + 1);
				}
			}
		}
		for (int t = 0; t < rv.length; t++) {
			System.out.println(Arrays.toString(rv[t]));
		}
		System.out.println(rv[n - 1][m - 1]);
	}

}
