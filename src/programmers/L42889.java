package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L42889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = solution(10, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 });
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int[] solution(int N, int[] stages) {
		Arrays.sort(stages);
		double[] now = new double[N + 2]; // 1부터 시작해서 N+1 단계까지 있기 떄문에
		int standard = 0; // 기준점이 되어 단계별로 비교하는것
		int fail = 0; // 실패한 사람을 저장하는 변수
		int people = stages.length;
		for (int i = 0; i < stages.length; i++) {
			if (standard < stages[i]) { // 변수 초기화
				now[standard] = ((double) fail / people);
				people -= fail;
				fail = 1;
				standard = stages[i];
			} else {
				fail++;
			}
			if (i == stages.length - 1) { // 마지막경우
				now[standard] = ((double) fail / people);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int s = 1; s <= N; s++) {
			list.add(s);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (now[a] > now[b]) {
					return -1;
				} else if (now[a] < now[b]) {
					return 1;
				} else {
					if (a > b)
						return 1;
					else if (a < b)
						return -1;
					else
						return 0;
				}
			}

		});
		int[] answer = new int[N];
		for (int s = 0; s < N; s++) {
			answer[s] = list.get(s);
		}
		return answer;
	}
}
