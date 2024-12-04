package baekjoon;

import java.util.Scanner;

public class N10430 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A, B, C;
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		System.out.println((A + B) % C);
		System.out.println(((A % C) + (B % C)) % C);
		System.out.println((A * B) % C);
		System.out.println(((A % C) * (B % C)) % C);
		scan.close();
	}
}
