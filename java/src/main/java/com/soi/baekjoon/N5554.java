package com.soi.baekjoon;

import java.util.Scanner;

public class N5554 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		scan.close();
		int timeall = a + b + c + d;
		System.out.println((int) (timeall / 60));
		System.out.println(timeall % 60);
	}

}
