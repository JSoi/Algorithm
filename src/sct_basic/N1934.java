package sct_basic;

import java.util.Scanner;

public class N1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		int[] resultarr = new int[testcase];
		for (int i = 0; i < testcase; i++) {
			int first = scan.nextInt();
			int second = scan.nextInt();
			resultarr[i] = giveLCM(first, second);
		}
		scan.close();
		for(int arrprint = 0; arrprint < testcase; arrprint++) {
			System.out.println(resultarr[arrprint]);
		}
	}

	public static int giveLCM(int first_nn, int second_nn) {
		int a = Math.min(first_nn, second_nn);
		int b = Math.max(first_nn, second_nn);
		int GCD = gcd(a, b);
		int LCM = (a * b) / GCD;
		return LCM;
	}

	// 유클리드 호제법 : 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 a와 b의 최대공약수는 b와 r의 최대공약수와
	// 같다.
	public static int gcd(int a, int b) {
		return (b % a) == 0 ? a : gcd(b, a % b);
	}

}
