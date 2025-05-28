package com.soi.programmers;

public class L42842 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = solution(10, 2);
		System.out.println("ANSWER : " + ans[0] + " , " + ans[1]);
	}

	// ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
	// ���� �β��� 1
	public static int[] solution(int b, int y) {
		int[] answer = new int[2];
		for (int g = (b + y) / 2; g >= (int) Math.sqrt(b + y); g--) {
			if ((b + y) % g != 0) {
				continue;
			}
			int garo = g;
			int sero = (b + y) / garo;
			if ((garo - 2) * (sero - 2) == y) {
				answer[0] = garo;
				answer[1] = sero;
				break;
			}
		}
		return answer;
	}
	// garo >=3

}
