package programmers;

public class L12909 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()()"));
	}

	static boolean solution(String s) {
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				val++;
			else
				val--;
			if (val < 0)
				return false;
		}
		if (val == 0)
			return true;
		else
			return false;
	}
}
