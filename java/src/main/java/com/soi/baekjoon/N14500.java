package com.soi.baekjoon;

import java.util.Scanner;

public class N14500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] one = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } } };
		int[][][] two = { { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } } };
		int[][][] three = { { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 0, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
				{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
				{ { 0, 0 }, { -1, 0 }, { 0, 1 }, { 0, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },
				{ { 0, 0 }, { 0, 1 }, { -1, 1 }, { -2, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } } };
		int[][][] four = { { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 1, 0 }, { 0, 1 }, { -1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } } };
		int[][][] five = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { -1, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } } };

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] block = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				block[i][j] = scan.nextInt();
			}
		}

		scan.close();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int tempAns = 0;
				int mini = 0;
				for (int[][] t : one) {
					mini = 0;
					for (int[] lt : t) {
						if (i + lt[0] < 0 || i + lt[0] >= n || j + lt[1] < 0 || j + lt[1] >= m) {
							mini = 0;
							continue;
						} else {
							mini += block[i + lt[0]][j + lt[1]];
						}
					}
					tempAns = Math.max(tempAns, mini);
				}
				for (int[][] t : two) {
					mini = 0;
					for (int[] lt : t) {
						if (i + lt[0] < 0 || i + lt[0] >= n || j + lt[1] < 0 || j + lt[1] >= m) {
							mini = 0;
							continue;
						} else {
							mini += block[i + lt[0]][j + lt[1]];
						}
					}
					tempAns = Math.max(tempAns, mini);
				}

				for (int[][] t : three) {
					mini = 0;
					for (int[] lt : t) {
						if (i + lt[0] < 0 || i + lt[0] >= n || j + lt[1] < 0 || j + lt[1] >= m) {
							mini = 0;
							continue;
						} else {
							mini += block[i + lt[0]][j + lt[1]];
						}
					}
					tempAns = Math.max(tempAns, mini);
				}
				for (int[][] t : four) {
					mini = 0;
					for (int[] lt : t) {
						if (i + lt[0] < 0 || i + lt[0] >= n || j + lt[1] < 0 || j + lt[1] >= m) {
							mini = 0;
							continue;
						} else {
							mini += block[i + lt[0]][j + lt[1]];
						}
					}
					tempAns = Math.max(tempAns, mini);
				}
				for (int[][] t : five) {
					mini = 0;
					for (int[] lt : t) {
						if (i + lt[0] < 0 || i + lt[0] >= n || j + lt[1] < 0 || j + lt[1] >= m) {
							mini = 0;
							continue;
						} else {
							mini += block[i + lt[0]][j + lt[1]];
						}
					}
					tempAns = Math.max(tempAns, mini);
				}
				answer = Math.max(answer, tempAns);
			}
		}

		System.out.println(answer);
	}

}
