package baekjoon;

import java.util.Scanner;

public class N10818_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputCase = scan.nextInt();
		int[] arr = new int[inputCase];
		for (int i = 0; i < inputCase; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		int max = arr[0];
		int min = arr[0];
		for (int input : arr) {
			max = Math.max(input, max);
			min = Math.min(input, min);
		}
		System.out.println(min + " " + max);
	}
}
