package baekjoon;

import java.util.Scanner;

public class N2869 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int v = scan.nextInt();
		scan.close();
		double sd = (double) v - a;
		System.out.println((int) Math.ceil(sd / (a - b)) + 1);
	}

}
