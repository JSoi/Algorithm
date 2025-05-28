package com.soi.programmers;

import java.util.Stack;

public class L42883 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("999", 2));
		System.out.println(solution("4177252841", 4));
	}

	// 1. MAX�� ���� ã�Ƽ� �յڷ� �ɰ� �� ��ͷ� Ǯ���..^^F
	public static String solution(String number, int k) {
		Stack<Integer> stk = new Stack<Integer>();
		String ans = "";
		for (int i = 0; i < number.length(); i++) { // ��� ���ҿ� ���� �����Ѵ�.
			int compare = Integer.parseInt(number.charAt(i) + ""); // i��° ���� ����
			while (!stk.isEmpty() && compare > stk.peek() && k-- > 0) {

				// System.out.println("compare : " + compare + " stack peek : " + stk.peek());
				/*
				 * 1. ������ ���� �ʰ� 2. �ش� ���� ���ÿ� ���������� ���� ������ ũ�� 3. �����ϴ� k���� 0 ���� Ŭ�� ������ ��� �����ϸ� ������
				 * POP���ش�
				 */
				stk.pop();
			}
			stk.push(compare);
		}

		while (stk.size() > number.length() - k) {
			stk.pop();
		}

		for (int i = 0; i < stk.size(); i++) {
			ans += stk.get(i) + "";
		}
		return ans;
	}
}
