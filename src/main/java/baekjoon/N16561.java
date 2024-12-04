package baekjoon;

import java.util.Scanner;

public class N16561 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		input /= 3;
		System.out.println((input - 1) * (input - 2) / 2);
		scan.close();
	}
}
