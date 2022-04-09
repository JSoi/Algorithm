package baekjoon;

import java.util.Scanner;

public class N1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());
		int hap = 0;
		int max = 0;
		for (int i = 0; i < cnt; i++) {
			int val = scan.nextInt();
			hap += val;
			max = Math.max(max, val);
		}
		double avg = (double) hap / (double) cnt / max * 100;
		System.out.println(avg);
	}

}
