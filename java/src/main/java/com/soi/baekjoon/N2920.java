package com.soi.baekjoon;
import java.util.Scanner;

public class N2920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int time[] = new int[8];
		for (int i = 0; i < 8; i++) {
			time[i] = scan.nextInt();
		}
		int cha = -3;
		for (int k = 0; k < 7; k++) {
			if (cha == -3) { // ó���̶�� �׳� ����
				cha = time[k + 1] - time[k];
			} else {
				if (cha != time[k + 1] - time[k]) {
					cha = -2;
					break;
				}
			}
		}
		
		if (cha == -2) {
			System.out.println("mixed");
		} else if (cha == 1) {
			System.out.println("ascending");
		} else {
			System.out.println("descending");
		}
		scan.close();
	}
}
