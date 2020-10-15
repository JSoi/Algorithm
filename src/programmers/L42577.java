package programmers;

import java.util.HashSet;

public class L42577 {

	public boolean solution(String[] phone_book) {
		HashSet<String> set = new HashSet<String>();
		for (String s : phone_book) {
			set.add(s);
		}
		for (String s : phone_book) {
			for (String key : set) {
				if (!s.equals(key) && s.length() < key.length() && key.startsWith(s)) {
					return false;
				}
			}
		}
		return true;
	}
}
