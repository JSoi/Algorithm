package com.soi.baekjoon;

import java.util.Scanner;

public class N1712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		long b = scan.nextLong();
		long c = scan.nextLong();
		scan.close();
		if (c - b <= 0)
			System.out.println(-1);
		else
			System.out.println((long) (a / (c - b)) + 1);
	}

}
