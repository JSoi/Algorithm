package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13699 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n + 1];
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int k = 0; k < i; k++) {
				arr[i] += arr[k] * arr[i - k - 1];

			}
		}
		System.out.println(arr[n]);
	}

}
