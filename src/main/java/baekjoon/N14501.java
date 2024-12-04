package baekjoon;

import java.util.Scanner;

public class N14501 {
	static int nowmoney = 0;
	static int[] day;
	static int[] moneyarr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		day = new int[count];
		moneyarr = new int[count];
		for (int i = 0; i < count; i++) {
			day[i] = scan.nextInt();
			moneyarr[i] = scan.nextInt();
		}
		scan.close();
		go(0, 0);
		System.out.println(nowmoney);
	}

	public static void go(int index, int money) {
		if (index >= day.length) { // 범주를 넘어갔을 때, 측정하지 않고 넘겨버린다
			nowmoney = Math.max(nowmoney, money);
			return;
		} else {
			go(index + day[index], index + day[index] > day.length ? money : money + moneyarr[index]);
			go(index + 1, money);
		}
	}

}
