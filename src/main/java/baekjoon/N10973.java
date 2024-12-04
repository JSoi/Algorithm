package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N10973 {
	static String target;
	static int count = 0;
	static String answer = "";
	static ArrayList<String> arr = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();

		scan.nextLine();

		target = scan.nextLine();
		target = target.trim();
		scan.close();

		boolean visit[] = new boolean[c + 1];
		visit[0] = true;

		per("", visit);
//		for(String s : arr) {
//			System.out.println(s);
//		}
		System.out.println(arr.indexOf(target) == 0 ? -1 : arr.get(arr.indexOf(target) - 1));

	}

	public static void per(String input, boolean[] v) {
		if (allV(v)) {
			input = input.trim();
			arr.add(input);
			return;
		}
		for (int i = 1; i <= v.length - 1; i++) {
			if (!v[i]) {
				v[i] = true;
				per(input + " " + i, v);
				v[i] = false;
			}
		}
	}

	public static boolean allV(boolean[] v) {
		for (boolean b : v) {
			if (!b)
				return false;
		}
		return true;
	}
}
