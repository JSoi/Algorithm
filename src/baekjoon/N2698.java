package baekjoon;

import java.util.Scanner;

public class N2698 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] dp = new int[101][100][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int n = 2; n <= 100; n++) {
			for (int k = 0; k < n; k++) {
				dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
				dp[n][k][1] = dp[n - 1][k][0] + ((k > 0) ? dp[n - 1][k - 1][1] : 0);
			}
		}
		Scanner scan = new Scanner(System.in);
		int tcase = scan.nextInt();
		// 인접한 비트가 1이되려면 무조건 11이 들어가야된다.
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < tcase; i++) {
			int n1 = scan.nextInt();
			int k1 = scan.nextInt();
			buf.append(dp[n1][k1][0] + dp[n1][k1][1] + "\n");
		}
		scan.close();
		System.out.println(buf.toString());
	}
}
