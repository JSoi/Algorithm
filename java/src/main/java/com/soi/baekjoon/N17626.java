package com.soi.baekjoon;

import java.util.Scanner;

public class N17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		int[] dp = new int[input + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int f = 1; f <= Math.sqrt(input); f++) {
			dp[f * f] = 1;
		}
		for (int i = 1; i <= input; i++) {
			if (dp[i] == 1) {
				continue;
			} else {
				for (int j = (int) Math.sqrt(i); j >= (int) Math.sqrt(i / 2); j--) {
					dp[i] = dp[i] == 0 ? (1 + dp[i - j * j]) : Math.min(dp[i], 1 + dp[i - j * j]);
				}
			}
		}
		System.out.println(dp[input]);
	}

}
