package baekjoon;

import java.util.Scanner;

public class N14888 {
	static int N;
	static long[] number;
	static long[] oper;
	static long max, min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		number = new long[N];
		oper = new long[4];
		for (int i = 0; i < N; i++) {
			number[i] = scan.nextInt();
		}
		for (int k = 0; k < 4; k++) {
			oper[k] = scan.nextInt();
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		go(number[0], 1);
		System.out.println(max);
		System.out.println(min);

	}

	static void go(long value, int index) {
		if (allUsed()) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (oper[i] != 0) {

				oper[i]--;
				switch (i) {
				case 0:
					go(value + number[index], index + 1);
					break;
				case 1:
					go(value - number[index], index + 1);
					break;
				case 2:
					go(value * number[index], index + 1);
					break;
				case 3:
					go(value / number[index], index + 1);
					break;
				default:
					break;
				}
				oper[i]++;
			}
		}
	}

	static boolean allUsed() {
		for (long b : oper) {
			if (b > 0) {
				return false;
			}
		}
		return true;
	}
}
