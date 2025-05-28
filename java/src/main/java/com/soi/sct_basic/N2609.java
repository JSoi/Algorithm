package com.soi.sct_basic;

/**
 * @author Soi
 * @problem �� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
import java.util.Scanner;

public class N2609 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan_nn = new Scanner(System.in);
		int first_nn = scan_nn.nextInt();
		int second_nn = scan_nn.nextInt();
		scan_nn.close();
		int a = Math.min(first_nn, second_nn);
		int b = Math.max(first_nn, second_nn);
		int GCD = gcd(a,b);
		int LCM = (a*b)/GCD;
		System.out.println(GCD);
		System.out.println(LCM);
	}

	//��Ŭ���� ȣ���� : 2���� �ڿ��� a, b�� ���ؼ� a�� b�� ���� �������� r�̶� �ϸ� a�� b�� �ִ������� b�� r�� �ִ������� ����.
	public static int gcd(int a, int b) {
		return (b % a) == 0 ? a : gcd(b, a % b);
	}
}
