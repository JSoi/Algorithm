package com.soi.programmers;

public class L12922 {
	public String solution(int n) {
		String answer = "";
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1)
				answer += "��";
			else
				answer += "��";
		}
		return answer;
	}
}
