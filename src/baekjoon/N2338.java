package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class N2338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BigInteger a = new BigInteger(scan.nextLine());
		BigInteger b = new BigInteger(scan.nextLine());
		scan.close();
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.divide(b));
	}

}
