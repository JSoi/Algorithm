package sct_basic;

import java.util.Scanner;

public class N9613 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		long[] resultarr = new long [testcase];
		for (int i = 0; i < testcase; i++) {
			int smallCount = scan.nextInt(); // 한 줄의 예제 개수
			int[] lineArray = new int[smallCount];
			for (int j = 0; j < smallCount; j++) {
				lineArray[j] = scan.nextInt();
			}
			long lineHap = 0;
			for (int fc = 0; fc < smallCount - 1; fc++) {
				for (int nc = 1; nc < smallCount - fc; nc++) {
					lineHap += giveGCD(lineArray[fc], lineArray[fc+nc]);
				}
			}
			resultarr[i] = lineHap;
		}
		scan.close();
		for (int arrprint = 0; arrprint < testcase; arrprint++) {
			System.out.println(resultarr[arrprint]);
		}
	}

	public static int giveGCD(int first_nn, int second_nn) {
		int a = Math.min(first_nn, second_nn);
		int b = Math.max(first_nn, second_nn);
		int GCD = gcd(a, b);
		return GCD;
	}

	// 유클리드 호제법 : 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 a와 b의 최대공약수는 b와 r의 최대공약수와
	// 같다.
	public static int gcd(int a, int b) {
		return (b % a) == 0 ? a : gcd(b, a % b);
	}
}
