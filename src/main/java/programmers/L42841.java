package programmers;

import java.util.ArrayList;

public class L42841 {
	// 숫자는 맞지만, 위치가 틀렸을 때는 볼
	// 숫자와 위치가 모두 맞을 때는 스트라이크
	// 숫자와 위치가 모두 틀렸을 때는 아웃
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[][] { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } }));
	}

	static ArrayList<Integer> numList;
	static boolean[] visit;

	// [세 자리의 수, 스트라이크의 수, 볼의 수] - 세 자리의 수는 서로 다른 수
	public static int solution(int[][] baseball) {
		int answer = 0;
		numList = new ArrayList<Integer>();
		visit = new boolean[10];
		// 스트라이크 먼저 처리하자(순서, 위치가 모두 맞으므로)
		makeNum("");
		for (int i = 0; i < numList.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < baseball.length; j++) {
				if (!ballorStrikeJudge(baseball[j][0], numList.get(i), baseball[j][1], baseball[j][2])) {
					flag = false;
					continue;
				}
			}
			if (flag)
				answer++;

		}
		return answer;
	}

	public static void makeNum(String num) {
		if (num.length() == 3)
			numList.add(Integer.parseInt(num));
		else {
			for (int i = 1; i < 10; i++) {
				if (!visit[i]) {
					visit[i] = true;
					makeNum(num + i);
					visit[i] = false;
				}

			}
		}
	}

	/**
	 * @param original baseball[][0]에 있는 기존의 Integer
	 * @param compare  Permutation으로 생성한 비교하고자 하는 Integer
	 * @param strike   ball[][1]에 있는 strike 변수값
	 * @param ball     ball[][2]에 있는 ball 변수값
	 * @return true|false - original, compare를 검사해 strike, ball이 일치하는지 return한다
	 */
	public static boolean ballorStrikeJudge(int original, int compare, int strike, int ball) {
		int strikeCompare = 0;
		int ballCompare = 0;
		boolean visit[] = new boolean[10];
		visit[Integer.parseInt((original + "").charAt(0) + "")] = true;
		visit[Integer.parseInt((original + "").charAt(1) + "")] = true;
		visit[Integer.parseInt((original + "").charAt(2) + "")] = true;
		while (original > 0) {
			if (original % 10 == compare % 10) {
				strikeCompare++;
			} else if (visit[compare % 10]) {
				ballCompare++;
			}
			original /= 10;
			compare /= 10;
		}
		if (strike != strikeCompare || ball != ballCompare) {
			return false;
		}
		return true;
	}

}
