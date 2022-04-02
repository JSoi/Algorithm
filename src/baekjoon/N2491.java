package baekjoon;

import java.util.Scanner;

public class N2491 {
	static int[] arr;
	static int maxLength;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		maxLength = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
	}

	public static void go(int start, int end, int bfValue) {
		if (arr[end] < bfValue) {
			maxLength = Math.max(maxLength, end - start + 1);
			return;
		}
	}

}
