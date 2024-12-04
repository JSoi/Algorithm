package baekjoon;

import java.util.Scanner;

public class N10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for (int i = 0; i < cases; i++) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			int count = 0;
			loop: for (int wi = 1; wi <= w; wi++) {
				for (int hi = 1; hi <= h; hi++) {
					count++;
					if (count == n) {
						System.out.printf("%d%02d\n", hi, wi);
						break loop;
					}
				}
			}
		}
		scan.close();
	}

}
