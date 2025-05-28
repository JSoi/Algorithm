package com.soi.baekjoon;

import java.util.Scanner;

public class N2588 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �μ��� ���̸� ������
		// �������� 3�ڸ� * 3�ڸ� �����̶�� �����ִ�!
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); // quotient - ���̶�� ���̴�! <-> remainder
		int b = scan.nextInt();
		scan.close();
		int f_value = 0;
		for (int rp = 1; rp < 1000; rp *= 10) {
			System.out.println(a * (b % 10));
			f_value += a * rp * (b % 10);
			b /= 10;
		}
		System.out.println(f_value);
	}

}