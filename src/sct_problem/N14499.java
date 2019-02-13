package sct_problem;

import java.util.Scanner;

public class N14499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int map_N = scan.nextInt();
		int map_M = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int k = scan.nextInt();
		int dice[] = { -1, 0, 0, 0, 0, 0, 0 };
		int xp[] = { 0, 0, 0, -1, 1 };
		int yp[] = { 0, 1, -1, 0, 0 };
		int Map[][] = new int[map_N][map_M];
		for (int i = 0; i < map_N; i++) {
			for (int l = 0; l < map_M; l++) {
				Map[i][l] = scan.nextInt();
			}
		}
		for (int q = 0; q < k; q++) {
			int position = scan.nextInt();
			int nx = x + xp[position];
			int ny = y + yp[position];
			if (nx < 0 || nx >= map_N || ny < 0 || ny >= map_M) {
				continue;
			}
			if (position == 1) { // µ¿
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
			} else if (position == 2) { // ¼­
				int temp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp;
			} else if (position == 3) { // ºÏ
				int temp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
			} else if (position == 4) { // ³²
				int temp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
			}
			x = nx;
			y = ny;
			if (Map[x][y] == 0) {
				Map[x][y] = dice[6];
			} else {
				dice[6] = Map[x][y];
				Map[x][y] = 0;
			}
			System.out.println(dice[1]);
		}
		scan.close();
	}

}
