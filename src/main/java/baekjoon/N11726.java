package baekjoon;

import java.util.Scanner;

public class N11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		int[] dp = new int[n];
		dp[0] = 1;
		if (n != 1) {
			dp[1] = 2;
		}
		for (int i = 2; i <= n - 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n - 1]);
	}

}
