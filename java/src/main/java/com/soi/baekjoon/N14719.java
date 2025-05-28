package com.soi.baekjoon;

import java.util.Scanner;

public class N14719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int sero = scan.nextInt();
		int garo = scan.nextInt();
		int answer = 0;
		int[] input = new int[garo];
		for (int line = 0; line < garo; line++) {
			input[line] = scan.nextInt();
		}
		scan.close();
		
		for (int i = 0; i < garo - 1; i++) {
			int gizun = input[i];
			int miniHap = 0;
			for (int j = i + 1; j < garo; j++) {
				if (gizun <= input[j]) {// ���δ�
					i = j;
					answer += miniHap;
					break;
				} else {
					miniHap += (gizun - input[j]);
				}
			}
		}
		for (int i = garo - 1; i > 1; i--) {
			int gizun = input[i];
			int miniHap = 0;
			for (int j = i - 1; j > 0; j--) {
				if (gizun <= input[j]) {// ���δ�
					i = j;
					answer += miniHap;
					break;
				} else {
					miniHap += (gizun - input[j]);
				}
			}
		}
		System.out.println(answer);
	}

}
