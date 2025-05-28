package com.soi.baekjoon;

import java.util.Scanner;

/**
 * @problem �˶��ð� 40������ ���߱�
 *
 */
public class N2884 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();
		scan.close();
		m -= 45;
		if (m < 0) {
			h -= 1;
			m += 60;
		}
		if (h < 0)
			h += 24;
		System.out.println(h + " " + m);
	}

}
