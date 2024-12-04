package baekjoon;

import java.util.Scanner;

public class N1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	static boolean isPrime(int input) {
		if (input < 2) {
			return false;
		} else {
			for (int i = 2; i * i <= input; i++) {
				if (input % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
