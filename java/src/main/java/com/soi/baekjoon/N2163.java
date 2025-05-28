package com.soi.baekjoon;

import java.util.Scanner;

public class N2163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.close();
		// top-bottom
		System.out.println(dp(n, m));

	}

	public static int dp(int n, int m) {
		if (n <= 1 || m <= 1)
			return 0;
		else {
			System.out.println(n + "/" + m);
			return dp(n, (int) (m / 2)) + dp(n, m - (int) (m / 2)) + dp((int) (n / 2), m) + dp(n - (int) (n / 2), m)
					+ 3;
		}
	}

}
