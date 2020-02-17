package swacademy;

import java.util.Scanner;

public class N9487 {
	static boolean[][] block;
	static boolean[] v;
	static int count;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		block = new boolean[n][n];
		v = new boolean[n];
		for (int j = 0; j < n - 1; j++) {
			int minia = scan.nextInt();
			int minib = scan.nextInt();
			block[minia - 1][minib - 1] = true;
		}

		v[a - 1] = v[b - 1] = true;
		count = 0;
	}

	public static void bt(int a, int b) {// ���� ����� a
		int a1, b1;
		for (int i = 0; i < n; i++) {
			if (block[a][i] && !v[i]) { // i�� ���� ��ΰ� �����ϰ� i�� �湮���� �ʾ��� �� a>i�� ���ߵ�
				v[i] = true;
				a1 = i;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (block[b][i] && !v[i]) { // i�� ���� ��ΰ� �����ϰ� i�� �湮���� �ʾ��� �� b>i�� ���ߵ�
				v[i] = true;
				b1 = i;
				break;
			}
		}
		count++;
	}

}
