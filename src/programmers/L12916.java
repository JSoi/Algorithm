package programmers;

public class L12916 {
	boolean solution(String s) {
		s = s.toUpperCase();
		int pc = 0;
		int yc = 0;
		char[] chunk = s.toCharArray();
		for (char a : chunk) {
			if (a == 'P') {
				pc++;
			} else if (a == 'Y') {
				yc++;
			}
		}
		if (pc == yc) {
			if (pc != 0)
				return true;
		}
		return false;
	}
}
