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

	// ��Ŭ���� ȣ���� : 2���� �ڿ��� a, b�� ���ؼ� a�� b�� ���� �������� r�̶� �ϸ� a�� b�� �ִ������� b�� r�� �ִ�������
	// ����.
	public static int gcd(int a, int b) {
		return (b % a) == 0 ? a : gcd(b, a % b);
	}

}
