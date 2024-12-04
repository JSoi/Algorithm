package sct_basic;

/**
 * @author Soi
 * @problem 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
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

	//유클리드 호제법 : 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
	public static int gcd(int a, int b) {
		return (b % a) == 0 ? a : gcd(b, a % b);
	}
}
