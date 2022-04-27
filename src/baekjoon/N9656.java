package baekjoon;

import java.util.Scanner;

public class N9656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		// 돌은 1개 혹은 3개 - 상근, 창영 순으로 시작
		// 마지막으로 돌을 가져가는 사람이 이김
		scan.close();
		int count = (n / 3) + (n % 3);
		System.out.println(count % 2 == 1 ? "CY" : "SK");
	}

}
