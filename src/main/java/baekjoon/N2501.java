package baekjoon;

import java.util.Scanner;

public class N2501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int count = scan.nextInt();
		scan.close();
		int miniCount = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				miniCount++;
				if (miniCount==count) {
					System.out.println(i);
					return;
				}
				else if (miniCount > count) {
					System.out.println(0);
					return;
				}
			}

		}
		System.out.println(0);
	}

}
