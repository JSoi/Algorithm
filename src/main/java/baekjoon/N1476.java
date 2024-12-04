package baekjoon;

import java.util.Scanner;

public class N1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M
		// (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
		Scanner scan = new Scanner(System.in);
		int E = scan.nextInt(); // 15X+E
		int S = scan.nextInt(); // 28Y+S
		int M = scan.nextInt(); // 19Z+M
		scan.close();
		int answer = 0;
		int ee = 0;
		int ss = 0;
		int mm = 0;
		while (true) {
//			System.out.println("answer :" + answer);
			answer++;
			ee = answer % 15 == 0 ? 15 : answer % 15;
			ss = answer % 28 == 0 ? 28 : answer % 28;
			mm = answer % 19 == 0 ? 19 : answer % 19;
//			System.out.println(ee + " / " + ss + " / " + mm);
			if (ee == E && ss == S && mm == M) {
				System.out.println(answer);
				return;
			}
		}

	}

}
