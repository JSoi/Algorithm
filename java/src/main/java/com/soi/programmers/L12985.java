package com.soi.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class L12985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 4, 7));
	}

	static int solution(int n, int a, int b) {
		int answer = 0;
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (b - a >= 1) {
			b = b % 2 == 1 ? (b = b / 2 + 1) : (b = b / 2);
			a = a % 2 == 1 ? (a = a / 2 + 1) : (a = a / 2);
			answer++;
		}
		return answer;
	}

	static int solution2(int n, int a, int b) {
		// �ð��ʰ�
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int c = 1; c <= n; c++) {
			arr.add(c);
		}
		for (int i = n; i > 1; i = i / 2) {
			answer++;
			ArrayList<Integer> removeList = new ArrayList<Integer>();
			for (int j = 0; j < i / 2; j++) {
				int k = j * 2;
				int l = j * 2 + 1;
				if (arr.get(k) == min && arr.get(l) == max) {
					return answer;
				}
				if (arr.get(k) == min || arr.get(k) == max) {
					removeList.add(l);
				} else if (arr.get(l) == min || arr.get(l) == max) {
					removeList.add(k);
				} else {
					removeList.add(k);
				}
			}
			Collections.sort(removeList, Collections.reverseOrder());
			for (int r : removeList) {
				arr.remove(r);
			}
		}
		return answer;
	}
}
