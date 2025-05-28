package com.soi.baekjoon;

import java.util.Scanner;

public class N2475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int e = scan.nextInt();
		scan.close();
		int result = (a*a + b*b + c*c + d*d + e*e) % 10;
		System.out.println(result);
	}

}
