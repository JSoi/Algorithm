package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579 {
	static int[] arr;
	static int cnt;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(buf.readLine());
		arr = new int[cnt + 1];
		dp = new Integer[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			arr[i] = Integer.parseInt(buf.readLine());
		}
		if (cnt == 2) {
			System.out.println(arr[1] + arr[2]);
			return;
		}
		if (cnt == 1) {
			System.out.println(arr[1]);
			return;
		}
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];

		System.out.println(go(cnt));
	}

	static int go(int n) {
		for (int i = 3; i <= cnt; i++) {
			dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
		}
		return dp[n];
	}

	static int go2(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(dp[n - 2], arr[n - 1] + dp[n - 3]) + arr[n];
		}
		return dp[n];
	}
}