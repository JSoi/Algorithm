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

	public static void bt(int a, int b) {// 현재 출발점 a
		int a1, b1;
		for (int i = 0; i < n; i++) {
			if (block[a][i] && !v[i]) { // i로 가는 경로가 존재하고 i를 방문하지 않았을 때 a>i로 가야됨
				v[i] = true;
				a1 = i;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (block[b][i] && !v[i]) { // i로 가는 경로가 존재하고 i를 방문하지 않았을 때 b>i로 가야됨
				v[i] = true;
				b1 = i;
				break;
			}
		}
		count++;
	}

}
