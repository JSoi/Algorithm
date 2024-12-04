package programmers;

public class L60058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(solution("(()())()"));
		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
		String answer = "";
		if (checkB(p) || p.equals(""))
			return p;
		int lr = 0;
		int i;
		for (i = 0; i < p.length(); i++) {

			if (p.charAt(i) == '(')
				lr++;
			else
				lr--;
			if (lr == 0)
				break;
		}
		String tempu = p.substring(0, i + 1);
		String tempv = p.substring(i + 1, p.length());

		System.out.println("u : " + tempu);
		System.out.println("v : " + tempv);
		if (checkB(tempu)) { // 균형잡힌 문자열이 아닌 경우
			answer += tempu + solution(tempv);
		} else {
			tempu = tempu.substring(1, tempu.length() - 1);
			String newu = "";
			for (int j = 0; j < tempu.length(); j++) {
				if (tempu.charAt(j) == '(')
					newu += ")";
				else
					newu += "(";
			}
			answer = "(" + solution(tempv) + ")" + newu;
		}
		return answer;
	}

	public static boolean checkB(String input) {
		int braclet = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(')
				braclet++;
			else
				braclet--;
			if (braclet < 0)
				return false;
		}
		return true;
	}
}
