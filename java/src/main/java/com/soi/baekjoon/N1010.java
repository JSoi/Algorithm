package com.soi.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class N1010 {
	// ������ �� ���� �ٸ�
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		StringBuffer buf = new StringBuffer();
		for (int c = 0; c < testcase; c++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			buf.append(solve(n, m) + "\n");
		}
		scan.close();
		System.out.println(buf.toString());
	}

	public static int solve(int n, int m) {
		int[][] myc = new int[n + 1][m + 1];
		for (int k = 0; k <= m; k++) {
			// 1���� ����Ʈ���� k���� ����Ʈ�� �������� ����� ���� k���̱� ������
			// 1���� ���ҿ��� k�� �Ҵ��� �ش�.
			myc[1][k] = k;
		}
		for (int i = 2; i <= n; i++) {
			// 2����� n����� �����Ѵ�.
			for (int j = i; j <= m; j++) {
				// i���� ����Ʈ���� j���� ����Ʈ�� ���� ����� ����..000000000000
				for (int l = j; l >= i; l--) {
					myc[i][j] += myc[i - 1][l - 1];
				}
			}
		}
		return myc[n][m];
	}

}
