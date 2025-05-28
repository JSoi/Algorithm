package com.soi.programmers;

import java.util.ArrayList;

public class L12900 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4));
	}

	static int solution(int n) {
		int a = 1;
		int b = 1;
		for (int i = 0; i < n - 1; i++) {
			// ���ڰ� �ʹ� Ŀ���� ���� �����ϱ� ���� �������� ���Ѵ�.
			int c = (a + b) % 1000000007;
			a = b;
			b = c;
		}
		return b;
	}
}
