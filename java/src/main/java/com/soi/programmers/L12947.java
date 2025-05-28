package com.soi.programmers;

public class L12947 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static boolean solution(int x) {
		int hap = 0;
		String str = "" + x;
		char xs[] = str.toCharArray();
		for (char a : xs) {
			hap += (int) a - 48;
		}
		if (x % hap == 0)
			return true;
		else
			return false;
	}
}
