package baekjoon;

import java.util.Scanner;

public class N13301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		long[] dp = new long[81];
		long[] dpt = new long[81];
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= 80; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		dpt[1] = 4;
		for (int i = 2; i <= 80; i++) {
			dpt[i] = dpt[i - 1] + dp[i] * 2;
		}
		System.out.println(dpt[input]);
	}

}
