package com.soi.programmers;

import java.util.Stack;

public class L12953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 2, 3, 4 }));
	}

	static int solution(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i : arr) {
			st.push(i);
		}
		while (st.size() > 1) {
			st.push(lcm(st.pop(), st.pop()));
		}

		return st.pop();
	}

	static int lcm(int a, int b) {
		int gcd = 1;
		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = Math.max(gcd, i);
			}
		}
		return a * (b / gcd);
	}

}
