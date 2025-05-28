package com.soi.programmers;

public class L12954 {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = x + i * x;
		}
		return answer;
	}
}
