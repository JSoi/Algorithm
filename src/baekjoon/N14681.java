package baekjoon;

import java.util.Scanner;

public class N14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y;
		int answer = 0;
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y = scan.nextInt();
		scan.close();
		if (x > 0) {
			if (y > 0) {
				answer = 1;
			} else {
				answer = 4;
			}
		} else {
			if (y > 0) {
				answer = 2;

			} else {
				answer = 3;
			}
		}
		System.out.println(answer);
	}

}
