package programmers;

import java.util.Arrays;

public class N42842_2 {
	static int[] solution(int brown, int yellow) {
		int hap = brown + yellow;

		return find(hap, brown, yellow);
	}

	static int[] find(int hap, int b, int y) {// 세로값
		for (int g = (b + y) / 2; g >= (int) Math.sqrt(b + y); g--) {
			if (hap % g != 0) {
				continue;
			} else {
				int s = hap / g; // 가로
				if ((s - 2) * (g - 2) == y) {
					return new int[] { g, s };
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(10, 2)));
	}

}
