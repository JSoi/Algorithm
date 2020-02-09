package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class L12915 {
	public String[] solution(String[] strings, int n) {
		ArrayList<String> list = new ArrayList<String>();
		for (String a : strings) {
			list.add(a);
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if (a.charAt(n) > b.charAt(n)) {
					return 1;
				} else if (a.charAt(n) < b.charAt(n)) {
					return -1;
				} else {
					return a.compareTo(b);
				}
			}

		});
		String[] answer = new String[strings.length];
		int ans = 0;
		for (String b : list) {
			answer[ans++] = b;
		}
		return answer;
	}

}
