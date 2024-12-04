package programmers;

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
			// 기준 값을 가지고 바로 큰 값이 나오게 되면.... 종료하고 값을 계산해 리턴한다
			int compare = i;
			int down = 0;
			int same = 0;
			int up = 0;
			if (citations[0] >= citations.length)
				// 만약 가장 작은 원소가 배열의 크기보다 작게 된다면, 배열의 길이가 정답이 된다.
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
