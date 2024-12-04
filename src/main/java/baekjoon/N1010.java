package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class N1010 {
	// 겹쳐질 수 없는 다리
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
			// 1개의 사이트에서 k개의 사이트로 연결짓는 경우의 수는 k개이기 때문에
			// 1행의 원소에는 k를 할당해 준다.
			myc[1][k] = k;
		}
		for (int i = 2; i <= n; i++) {
			// 2행부터 n행까지 진행한다.
			for (int j = i; j <= m; j++) {
				// i개의 사이트에서 j개의 사이트로 가는 경우의 수는..000000000000
				for (int l = j; l >= i; l--) {
					myc[i][j] += myc[i - 1][l - 1];
				}
			}
		}
		return myc[n][m];
	}

}
