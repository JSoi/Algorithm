package com.soi.programmers;

public class L12925 {
	public int solution(String s) {
		if (s.charAt(0) == '-')
			return (-1) * Integer.parseInt(s.substring(1, s.length()));
		else
			return Integer.parseInt(s);
	}
}
