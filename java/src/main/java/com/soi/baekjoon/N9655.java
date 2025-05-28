package com.soi.baekjoon;

import java.util.Scanner;

public class N9655 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		int answer = n / 3 + n % 3;
		System.out.println(answer % 2 == 1 ? "SK" : "CY");
	}

}
