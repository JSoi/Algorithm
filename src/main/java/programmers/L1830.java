package programmers;


public class L1830 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("HaEaLaLaObWORLDb"));
	}

//소문자를 스팸 기호로 처리한다.
	static String solution(String sentence) {
		String answer = "";
		answer = sol(sentence);
		return answer;
	}

	static String sol(String sentence) {
		String answer = "";
		for (int i = 0; i < sentence.length(); i++) {
			char a = sentence.charAt(i);
			if (a >= 'a' && a <= 'z') {
				String second = sol(second(sentence, a));
				String first = first(sentence, a);
				if (first.equals("")) {
					answer += second + " ";
					i = sentence.lastIndexOf(a) + 2;
				} else {
					answer += first + " ";
					i = sentence.lastIndexOf(a) + 1;
				}
//				System.out.println("answer " + answer);
			}
		}
		if (answer.equals("")) {
//			System.out.println("check : " + sentence);
			return sentence;
		} else
			return answer.trim();
	}

	static String first(String input, char c) {
		String result = "";
		if (input.indexOf(c) - 1 < 0 || input.lastIndexOf(c) + 1 >= input.length())
			return "";
		for (int i = input.indexOf(c) - 1; i <= input.lastIndexOf(c) + 1; i += 2) {
			if (input.charAt(i) < 'A' || input.charAt(i) > 'Z')
				return "";
			else
				result += input.charAt(i);

		}
//		System.out.println("first : " + result);
		return result;
	}

	static String second(String input, char c) {
		int count = 0;
		String result = "";
		for (int i = input.indexOf(c); i <= input.lastIndexOf(c); i++) {
			if (c == input.charAt(i))
				count++;
			if (i != input.indexOf(c) && i != input.lastIndexOf(c)) {
				result += input.charAt(i);
			}
		}

//		System.out.println("second : " + result);
		if (count != 2)
			return "";
		else
			return result;
	}
}
