package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L42840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 2, 4, 2 };
		// System.out.println("first : " + Arrays.toString(solution(arr)));
	}
	// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	//
	// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
	// ...

	/**
	 * 1) 정답을 훑어서 1,2,3에 정답을 하나씩 더하는 경우 2) 1,2,3을 모두 생성해서 정답과 다 비교하는 경우
	 */

	public static int[] solution(int[] answers) {
		int[] fo = { 1, 2, 3, 4, 5 };
		int[] so = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] to = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int corr_f = 0, corr_s = 0, corr_t = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == fo[i % 5])
				corr_f++;
			if (answers[i] == so[i % 8])
				corr_s++;
			if (answers[i] == to[i % 10])
				corr_t++;
		}
		int max = Math.max(Math.max(corr_f, corr_s), corr_t);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (max == corr_f)
			list.add(1);
		if (max == corr_s)
			list.add(2);
		if (max == corr_t)
			list.add(3);
		int answer[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static int[] solution2(int[] answers) {
		int[] bestScore = new int[3];
		int[] a1 = { 1, 2, 3, 4, 5 }; // len : 5
		int[] a2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // len : 8
		int[] a3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // len : 10
		for (int i = 0; i < answers.length; i++) {
			int a = answers[i];
			if (a1[i % 5] == a)
				bestScore[0]++;
			if (a2[i % 8] == a)
				bestScore[1]++;
			if (a3[i % 10] == a)
				bestScore[2]++;
		}
		int big = Math.max(bestScore[0], Math.max(bestScore[1], bestScore[2]));
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < 3; j++) {
			if (bestScore[j] == big) {
				list.add(j);
			}
		}
		int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

		return answer;
	}
}