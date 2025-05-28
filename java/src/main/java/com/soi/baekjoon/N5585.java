package com.soi.baekjoon;

import java.util.Scanner;

public class N5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int coins[] = { 500, 100, 50, 10, 5, 1 };
		int input = scan.nextInt();
		scan.close();
		int moneyreturn = 1000 - input;
		int many = 0;
		for (int i = 0; i < coins.length; i++) {
			int temp = (int) (moneyreturn / coins[i]);
			many += temp;
			// System.out.println("temp : " + temp);
			moneyreturn -= temp * coins[i];
		}
		System.out.println(many);
	}

}
