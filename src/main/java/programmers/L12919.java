package programmers;

public class L12919 {
	public String solution(String[] seoul) {
		int i;
		for (i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				return "김서방은 " + i + "에 있다";
			}
		}
		return "";
	}
}
