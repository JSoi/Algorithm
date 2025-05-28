package com.soi.programmers;

public class L12917 {
	public String solution(String s) {
		String answer = "";
		char split[] = s.toCharArray();
		for (int j = 0; j < split.length; j++) {
			for (int i = 0; i < j; i++) {
				if (split[i] < split[j]) {
					char k = split[i];
					split[i] = split[j];
					split[j] = k;
				}
			}
		}
		for (char a : split) {
			answer += a;
		}
		return answer;
	}
}
