package com.soi.programmers;

import java.util.Arrays;

public class L42747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(solution(new int[] { 5, 5, 5, 5 }));
		// System.out.println(solution(new int[] { 22, 42 }));
	}

	public static int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = citations[0]; i <= citations[citations.length - 1]; i++) {
			// ���� ���� ������ �ٷ� ū ���� ������ �Ǹ�.... �����ϰ� ���� ����� �����Ѵ�
			int compare = i;
			int down = 0;
			int same = 0;
			int up = 0;
			if (citations[0] >= citations.length)
				// ���� ���� ���� ���Ұ� �迭�� ũ�⺸�� �۰� �ȴٸ�, �迭�� ���̰� ������ �ȴ�.
				return citations.length;
			for (int j = 0; j < citations.length; j++) {
				if (citations[j] > compare) {
					break;
				} else if (citations[j] == compare) {
					same++;
				} else {
					down++;
				}
			}
			down += same;
			up = citations.length - down + same;
			if (up >= compare && down <= compare)
				answer = Math.max(answer, compare);
		}
		return answer;
	}
}
