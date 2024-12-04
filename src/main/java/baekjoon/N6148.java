package baekjoon;

import java.util.Scanner;

public class N6148 {
	public static long[] h;
	public static int n;
	public static long b;
	public static long answer = Long.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		b = scan.nextLong();
		h = new long[n];
		for (int i = 0; i < n; i++) {
			int a = scan.nextInt();
			h[i] = a;
		}
		scan.close();
		dfs(0,0);
		System.out.println(answer);
	}

	public static void dfs(int i, long sum) {
		if (sum >= b) {
			answer = Math.min(answer, sum - b);
		} else if (i < n) {
			dfs(i + 1, sum + h[i]);
			dfs(i + 1, sum);
		}
	}
}
