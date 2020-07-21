package programmers;

import java.util.ArrayList;

public class L1835 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(2, new String[] { "N~F=0", "R~T>2" }));
		// System.out.println(solution(2, new String[] { "M~C<2", "C~M>1" }));
	}

	static char[] character = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static ArrayList<String> lines;
	static String[] conditions;

	public static int solution(int n, String[] data) {
		lines = new ArrayList<String>();
		conditions = data.clone();
		boolean visit[] = new boolean[8];
		giveLineMini("", visit);
		return lines.size();
	}

	public static boolean torf(String s, String condition) {
		char a = condition.charAt(0);
		char b = condition.charAt(2);
		char cond = condition.charAt(3);
		int counttoInt = Integer.parseInt(condition.charAt(4) + "");
		int bet = Math.abs(s.indexOf(a) - s.indexOf(b)) - 1;
		switch (cond) {
		case '=':
			if (bet != counttoInt)
				return false;
			break;
		case '>':
			if (bet <= counttoInt)
				return false;
			break;
		case '<':
			if (bet >= counttoInt)
				return false;
			break;
		}
		return true;
	}

	public static void giveLineMini(String line, boolean visit[]) {
		if (line.length() == 8) {
			for (String con : conditions) {
				if (!torf(line, con)) {
					return;
				}
			}
			lines.add(line);
			return;
		} else {
			for (int i = 0; i < 8; i++) {
				if (!visit[i]) {
					visit[i] = true;
					giveLineMini(line + character[i], visit);
					visit[i] = false;
				}
			}
		}
	}
}
