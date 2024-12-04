package baekjoon;

import java.util.Scanner;

public class N11022 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer buf = new StringBuffer();
		int time = scan.nextInt();
		for (int r = 0; r < time; r++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			buf.append("Case #" + (r + 1) + ": " + a + " + " + b + " = " + (a + b) + "\n");
		}
		scan.close();
		System.out.print(buf.toString());
	}

}
