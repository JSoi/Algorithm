package programmers;

import java.util.Stack;

public class L42883 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("999", 2));
		System.out.println(solution("4177252841", 4));
	}

	// 1. MAX를 먼저 찾아서 앞뒤로 쪼갠 뒤 재귀로 풀어보자..^^F
	public static String solution(String number, int k) {
		Stack<Integer> stk = new Stack<Integer>();
		String ans = "";
		for (int i = 0; i < number.length(); i++) { // 모든 원소에 관해 조사한다.
			int compare = Integer.parseInt(number.charAt(i) + ""); // i번째 원소 저장
			while (!stk.isEmpty() && compare > stk.peek() && k-- > 0) {

				// System.out.println("compare : " + compare + " stack peek : " + stk.peek());
				/*
				 * 1. 스택이 비지 않고 2. 해당 값이 스택에 마지막으로 넣은 값보다 크고 3. 제거하는 k값이 0 보다 클때 조건을 모두 만족하면 스택을
				 * POP해준다
				 */
				stk.pop();
			}
			stk.push(compare);
		}

		while (stk.size() > number.length() - k) {
			stk.pop();
		}

		for (int i = 0; i < stk.size(); i++) {
			ans += stk.get(i) + "";
		}
		return ans;
	}
}
