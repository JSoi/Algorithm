package com.soi.baekjoon;
import java.util.Scanner;

public class N11721 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String month = scan.nextLine();
		char[] input = month.toCharArray();
		int line = input.length / 10;
		for (int i = 0; i < line + 1; i++) {
			for (int j = i * 10; j < i * 10 + 10; j++) {
				if(j<=input.length-1) {
					System.out.print(input[j]);
				}
			}
			System.out.println();
		}
		scan.close();
	}
}
