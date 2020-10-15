package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		int[] dp = new int[input+1];
		dp[1] = 1;
		for (int f = 1; f <= Math.sqrt(input); f++) {
			dp[f * f] = 1;
		}
		for (int i = 1; i <= Math.sqrt(input); i++) {
			for (int j = i * i + 1; (j < (i + 1) * (i + 1)) && (j <= input); j++) {
				dp[j] = dp[i * i] + dp[j - (i * i)];
//				System.out.println("C");
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[input]);
	}

}
