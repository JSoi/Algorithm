package baekjoon;

import java.util.Scanner;

public class N1697 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // ¼öºó
		int K = scan.nextInt(); // µ¿»ý
		scan.close();

		int[] path = new int[1000001];
		for (int i = 0; i < path.length; i++) {
			path[i] = 1000001;
		}
		path[N] = 0;
		if (N < K) {
			for (int m = 0; m < N; m++) {
				path[m] = N - m;
			}
			for (int i = N + 1; i <= K; i++) {
				if (i % 2 == 0) {// i°¡ Â¦¼ö
					path[i] = Math.min(Math.min(path[i - 1] + 1, path[i + 1] + 1), path[i / 2] + 1);
				} else {
					path[i] = Math.min(path[i - 1] + 1, path[(i + 1) / 2] + 2);
				}
				path[i * 2] = path[i] + 1;
			}
			System.out.println(path[K]);
		} else {
			System.out.println(N - K);
		}
	}
}
