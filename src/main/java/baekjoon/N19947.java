package baekjoon;

import java.util.Scanner;

public class N19947 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		int year = scan.nextInt();
		scan.close();
		int[] dp = new int[year + 1];
		dp[0] = money;
		for (int i = 0; i <= year; i++) {
			if (i + 1 <= year) {
				dp[i + 1] = (int) Math.max(dp[i + 1], dp[i] * 1.05);
			}
			if (i + 3 <= year) {
				dp[i + 3] = (int) Math.max(dp[i + 3], dp[i] * 1.2);
			}
			if (i + 5 <= year) {
				dp[i + 5] = (int) Math.max(dp[i + 5], dp[i] * 1.35);
			}
		}
		System.out.println(dp[year]);
	}

}
