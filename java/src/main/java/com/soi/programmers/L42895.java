package com.soi.programmers;

public class L42895 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5, 12));
	}

	static int answer = -1;

	public static int solution(int N, int number) {
		sol(N, number, 0, 0);
		return answer;
	}

	public static void sol(int N, int number, int count, int pre) {
		int tempN = N;
		if (count > 8) {
			answer = -1;
			return;
		}
		if (number == pre) {
			if (answer == -1 || answer > count) {
				answer = count;
			}
			return;
		}
		for (int i = 0; i < 8 - count; i++) {
			sol(N, number, count + i + 1, pre - tempN);
			sol(N, number, count + i + 1, pre + tempN);
			sol(N, number, count + i + 1, pre * tempN);
			sol(N, number, count + i + 1, pre / tempN);
			tempN = tempN * 10 + N;
		}
	}
}
