package baekjoon;

import java.util.Scanner;

public class N2588 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 인수를 줄이면 좋을듯
		// 문제에서 3자리 * 3자리 연산이라고 나와있다!
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); // quotient - 몫이라는 뜻이다! <-> remainder
		int b = scan.nextInt();
		scan.close();
		int f_value = 0;
		for (int rp = 1; rp < 1000; rp *= 10) {
			System.out.println(a * (b % 10));
			f_value += a * rp * (b % 10);
			b /= 10;
		}
		System.out.println(f_value);
	}

}