package com.soi.programmers;

public class L12918 {
	public boolean solution(String s) {
		if (s.length() != 4 && s.length() != 6)
			return false;
		char check[] = s.toCharArray();
		for (int i = 0; i < check.length; i++) {
			if (check[i] < 48 || check[i] > 57) {
				return false;
			}
		}
		return true;
	}
}
