package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class N12865 {
	static int count;
	static int weight;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		count = scan.nextInt();
		weight = scan.nextInt();
		dp = new int[count + 1][weight + 1];
		for (int i = 1; i < count + 1; i++) {
			int wVal = scan.nextInt(); // weight
			int vVal = scan.nextInt(); // value

			for (int j = 1; j < weight + 1; j++) {
				if (j < wVal) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(vVal + dp[i-1][j-wVal], dp[i-1][j]);
				}
			}
		}
		scan.close();
		System.out.println(dp[count][weight]);
	}

}
