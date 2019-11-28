package baekjoon;

import java.util.Scanner;

public class N2775 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuffer buf = new StringBuffer();
		int apart[][] = new int[15][15];
		for (int k = 0; k < 15; k++)
			apart[0][k] = k;
		for (int i = 1; i < 15; i++) {
			int hap = 0;
			for (int j = 1; j < 15; j++) {
				hap += apart[i-1][j];
				apart[i][j] = hap;
			}
		}
		int cases = scan.nextInt();
		for (int c = 0; c < cases; c++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			buf.append(apart[a][b]+"\n");
		}
		scan.close();
		System.out.println(buf.toString());
	}
}
