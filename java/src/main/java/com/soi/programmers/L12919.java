package com.soi.programmers;

public class L12919 {
	public String solution(String[] seoul) {
		int i;
		for (i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				return "�輭���� " + i + "�� �ִ�";
			}
		}
		return "";
	}
}
