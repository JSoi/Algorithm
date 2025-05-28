package com.soi.baekjoon;

import java.util.Scanner;

public class N9656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		// ���� 1�� Ȥ�� 3�� - ���, â�� ������ ����
		// ���������� ���� �������� ����� �̱�
		scan.close();
		int count = (n / 3) + (n % 3);
		System.out.println(count % 2 == 1 ? "CY" : "SK");
	}

}
