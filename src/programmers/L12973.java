package programmers;

import java.util.Stack;

public class L12973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("baabaa"));
	}

	static int solution(String s) {
		// 순차적으로 들어오는 것을 반응하며 즉각 처리 -> 스택을 이용
		Stack<Character> st = new Stack<Character>();
		char c[] = s.toCharArray();
		for (char a : c) {
			if (!st.isEmpty() && st.peek() == a) {
				st.pop();
			} else {
				st.push(a);
			}
		}
		return st.isEmpty() ? 1 : 0;
	}

	static int wrongsolution(String s) {
		// abbaaabba 처리불가
		String old = "";
		while (!s.equals(old)) {
			old = s;
			s = s.replace("aa", "");
			s = s.replace("bb", "");
		}
		if (s.length() > 0)
			return 0;
		else
			return 1;
	}
}
