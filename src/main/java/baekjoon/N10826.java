package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class N10826 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		if(input==0) {
			System.out.println(0);
			return;
		}
		BigInteger[] arr = new BigInteger[input + 1];
		arr[0] = new BigInteger("0");
		arr[1] = new BigInteger("1");
		for (int i = 2; i <= input; i++) {
			arr[i] = arr[i - 1].add(arr[i - 2]);
		}
		System.out.println(arr[input]);
	}

}
