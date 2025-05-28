package com.soi.baekjoon;

import java.util.Scanner;

public class N16395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.close();
		int[][] p = new int[n][n];
		// initialize
		for (int i = 0; i < n; i++) {
			p[i][0] = 1;
			p[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				p[i][j] = p[i][j - 1] + p[i - 1][j];
			}
		}
		System.out.println(p[n-k][k-1]);
	}

}
