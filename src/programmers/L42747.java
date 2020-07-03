package programmers;

import java.util.Arrays;

public class L42747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(solution(new int[] { 5, 5, 5, 5}));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		for (int i = citations[0]; i <= citations[citations.length - 1]; i++) {
			// 기준 값을 가지고 바로 큰 값이 나오게 되면.... 종료하고 값을 계산해 리턴한다
			int compare = i;
			int down = 0;
			int same = 0;
			int up = 0;
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
			System.out.println("down  : " + down + " / up : " + up);
			System.out.println("compare : " + compare);
			
			if (up >= compare && citations.length-up <= compare)
				answer = Math.max(answer, compare);
		}
		return answer;
	}
}
