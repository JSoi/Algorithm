package com.soi.baekjoon;

import java.util.Scanner;

public class N10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = -1;
		int b = 11;
		StringBuffer buf = new StringBuffer();
		while (true) {
			a = scan.nextInt();
			b = scan.nextInt();
			if(a == 0 && b == 0) break;
			buf.append(a+b+"\n");
		}
		scan.close();
		System.out.println(buf.toString());
	}

}
