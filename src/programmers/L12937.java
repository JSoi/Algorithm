package programmers;

public class L12937 {
	public String solution(int num) {
		String temp = num + "";
		num = (int) temp.charAt(temp.length() - 1);
		String answer = "";
		if (num % 2 == 1)
			answer = "Odd";
		else
			answer = "Even";
		return answer;
	}
}
