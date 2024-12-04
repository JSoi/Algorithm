package baekjoon;

import java.util.Scanner;

public class N2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int index = 0;
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 9; i++) {
			int cone = scan.nextInt();
			if (cone >= max) {
				max = cone;
				index = i;
			}
		}
		scan.close();
		System.out.println(max);
		System.out.println(index);
	}

}
