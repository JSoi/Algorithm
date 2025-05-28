package com.soi.baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int left[] = new int[10];
		for (int i = 0; i < 10; i++) {
			left[i] = scan.nextInt() % 42;
		}
		scan.close();
		int end = left.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < end; i++) {
			set.add(left[i]);
		}
		System.out.println(set.size());
	}

}
