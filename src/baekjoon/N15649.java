package baekjoon;

import java.util.*;

public class N15649 {
	static int number, count;
	static StringBuilder sb = new StringBuilder();
	static int[] array;

	static void rec_func(int k) {
		if (k == count + 1) {
			for (int i = 1; i <= count; i++) {
				sb.append(array[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int j = 1; j <= number; j++) {
				array[k] = j;
				rec_func(k + 1);
				array[k] = 0;
			}
		}
	}

	static void scan() {
		Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		count = scan.nextInt();
		scan.close();
		array = new int[count + 1];
	}

	public static void main(String[] args) {
		scan();
		rec_func(1);
		System.out.println(sb.toString());
	}

}
