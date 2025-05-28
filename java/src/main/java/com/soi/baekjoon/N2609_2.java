package com.soi.baekjoon;

import java.util.Scanner;

public class N2609_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		System.out.println(gcd(a,b));
		System.out.println(lcd(a,b));
	}

	static int gcd(int a, int b) {// �ִ�����
		int min = Math.min(a, b);
		int answer = 0;
		for (int i = 1; i <= min; i++) {
			if ((a % i == 0) && (b % i == 0)) {
				answer = i;
			}
		}
		return answer;
	}

	static int lcd(int a, int b) {
		int gcd = gcd(a,b);
		return a*b/gcd;
	}

}
