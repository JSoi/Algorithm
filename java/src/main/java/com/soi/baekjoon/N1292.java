package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N1292 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt();
		int end = scan.nextInt();
		int hap = 0;
		int number = 1;
		ArrayList<Integer> list = new ArrayList<>();
		loop: for (int i = 0; i < end; i++) {
			for (int j = i + 1; j > 0; j--) {
				list.add(number);
				if (list.size() > end) {
					break loop;
				}
			}
			number++;
		}

		for (int i = start - 1; i < end; i++) {
			hap += list.get(i);
		}
		System.out.println(hap);
	}
}
