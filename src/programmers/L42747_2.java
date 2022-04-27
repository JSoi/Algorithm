package programmers;

import java.util.Arrays;
import java.util.Collections;

public class L42747_2 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
	}

	static int solution(int[] citations) {
		int N = citations.length;
		int answer = 0;
		Arrays.sort(citations);
		// 0 1 3 5 6 
		// 6 5 3 1 0 순으로 접근
		// 개수 위주로 접근하는 게 좋을 것 같다
		for (int i = N - 1; i >= 0; i--) {
			if (answer < citations[i]) {
				answer++;
			} else {
				break;
			}
		}
		return answer;
	}
}
