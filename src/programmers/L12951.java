package programmers;

import java.util.ArrayList;

public class L12951 {
	// JadenCase 문자열 만들기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3people unFollowed me"));
	}

	static String solution(String s) {
		String answer = "";
		s = s.toLowerCase();
		int index = 0;
		String splitS[] = s.split(" ");
		ArrayList<Integer> chngIdx = new ArrayList<Integer>();
		for (int i = 0; i < splitS.length && index < s.length(); i++) {
			int smallL = splitS[i].length();
			if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z')
				chngIdx.add(index);
			index += (smallL + 1);
		}
		char[] temp = s.toCharArray();
		for (int in : chngIdx) {
			temp[in] -= 32;
		}
		for (char a : temp) {
			answer += a;
		}
		return answer;
	}
}
