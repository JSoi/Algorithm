package baekjoon;

import java.util.Scanner;

public class N9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		int solve[] = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			int val = scan.nextInt();
			solve[i] = val;
		}
		scan.close();
		long[] function = new long[101];
		function[1] = function[2] = function[3] = 1;
		for (int i = 4; i <= 100; i++) {
			function[i] = function[i - 2] + function[i - 3];
		}
		StringBuffer buf = new StringBuffer();
		for (int v : solve) {
			buf.append(function[v] + "\n");
		}
		System.out.println(buf.toString());
	}

}
