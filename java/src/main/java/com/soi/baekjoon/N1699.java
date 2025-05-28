package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1699 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] dp = new int[input + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = dp[0] = 1;
		for (int i = 1; i <= input; i++) {
			if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i) {
				// ������������ ���
				dp[i] = 1;
			} else {
				for (int m = (int) Math.sqrt(i); m >= 1; m--) {
					dp[i] = Math.min(dp[i], 1 + dp[i - m * m]);
				}
			}
		}
		System.out.println(dp[input]);
	}

}
