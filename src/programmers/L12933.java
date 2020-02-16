package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class L12933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long input = scan.nextLong();
		System.out.println(solution(input));
		scan.close();
	}

	public static long solution(long n) {
		ArrayList<Long> list = new ArrayList<Long>();
		while (n > 0) {
			list.add(n % 10);
			n /= 10;
		}
		Collections.sort(list,Collections.reverseOrder());
		String temp = "";
		for (long a : list) {
			temp += a;
		}
		long answer = Long.parseLong(temp);
		return answer;
	}
}
