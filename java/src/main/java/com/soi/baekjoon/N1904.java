package com.soi.baekjoon;

import java.util.Scanner;

public class N1904 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		int dp[] = new int[n + 2];
		dp[1] = 1;
		dp[2] = 2;
		if (n <= 2) {
			System.out.println(dp[n]);
			return;
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		}
		System.out.println(dp[n]);
	}

}
