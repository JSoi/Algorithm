package com.soi.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class N2504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int gop = 1;
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '[':
				stack.push(c);
				gop *= 3;
				break;
			case '(':
				stack.push(c);
				gop *= 2;
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					System.out.println(0);
					return;
				}
				if (str.charAt(i - 1) == '[') {
					answer += gop;
				}
				stack.pop();
				gop /= 3;
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					System.out.println(0);
					return;
				}
				if (str.charAt(i - 1) == '(') {
					answer += gop;
				}
				stack.pop();
				gop /= 2;
				break;
			}
		}
		if (stack.isEmpty()) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}
	}

}
