package programmers;

import java.util.ArrayList;

public class L12900 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4));
	}

	static int solution(int n) {
		int a = 1;
		int b = 1;
		for (int i = 0; i < n - 1; i++) {
			// 숫자가 너무 커지는 것을 방지하기 위해 나머지를 구한다.
			int c = (a + b) % 1000000007;
			a = b;
			b = c;
		}
		return b;
	}
}
