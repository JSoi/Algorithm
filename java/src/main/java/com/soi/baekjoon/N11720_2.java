package com.soi.baekjoon;

import java.util.Scanner;

public class N11720_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		scan.nextLine();
		int hap = 0;
		String line = scan.nextLine();
		char[] ch = line.toCharArray();
		for (int i = 0; i < cnt; i++) {
			hap += Integer.valueOf(ch[i]+"");
		}
		System.out.println(hap);
	}

}
