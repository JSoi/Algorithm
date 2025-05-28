package com.soi.baekjoon;

import java.util.Scanner;

public class N14916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		scan.close();
		int answer = Integer.MAX_VALUE;
		for (int i = money / 5; i >= 0; i--) {
			if ((money - i * 5) % 2 == 0) {
				answer = Math.min(i + (money - i * 5) / 2, answer);
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

}
