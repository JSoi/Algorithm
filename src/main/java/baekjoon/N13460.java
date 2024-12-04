package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N13460 {
	private static int answer;
	private final static int[] dx = { 1, 0, -1, 0 };
	private final static int[] dy = { 0, 1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answer = Integer.MAX_VALUE;
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		char[][] map = new char[m][n];
		scan.nextLine();
		for (int i = 0; i < m; i++) {
			String str = scan.nextLine();
			map[i] = str.toCharArray();
		}
		scan.close();
		move(0, map);
		System.out.println(answer);
	}

	public static void move(int moveCount, char[][] input) {
		if (moveCount > 10)
			return;
		for (int k = 0; k < 4; k++) {
			char[][] map = input.clone();

			for (int i = 1; i < map.length - 1; i++) {
				for (int j = 1; j < map[0].length - 1; j++) {
					if (map[i][j] == 'B' || map[i][j] == 'R') {
						int pointX = i;
						int pointY = j;
						char now = map[pointX][pointY];
						map[pointX][pointY] = '.';
						while (map[pointX + dx[k]][pointY + dy[k]] == '.') {
							pointX += dx[k];
							pointY += dy[k];
							if (map[pointX][pointY] == 'O') {
								if (now == 'R') {
									answer = Math.min(moveCount, answer);
									return;
								}
								now = '.';
							}
						}
						map[pointX][pointY] = now;
					}
				}
			}
			move(moveCount + 1, map);
		}
	}
}
