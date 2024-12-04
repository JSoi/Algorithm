package baekjoon;

import java.util.Scanner;

public class N5565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int price = scan.nextInt();
		for(int i = 0; i < 9; i++) {
			int temp = scan.nextInt();
			price-=temp;
		}
		scan.close();
		System.out.println(price);
	}

}
