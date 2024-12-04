package baekjoon;

import java.util.Scanner;

public class N15489 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		int W = scan.nextInt();
		int[][] tree = new int[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					tree[i][j] = 1;
				} else {
					tree[i][j] = tree[i - 1][j] + tree[i - 1][j - 1];
				}
//				System.out.print(tree[i][j] + " ");
			}
//			System.out.println();
		}
		int answer = 0;
		for (int i = R - 1; i < R + W - 1; i++) {
			int co = i + 1 - R;
			for (int j = C - 1; j < C + co; j++) {
				answer += tree[i][j];
//				System.out.println(i + " / " + j);
			}
		}
		System.out.println(answer);
	}

}
