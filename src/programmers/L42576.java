package programmers;

import java.util.HashMap;

public class L42576 {
	public static void main(String args[]) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String start : participant) {
			map.put(start, map.getOrDefault(start, 0) + 1);
		}
		for (String end : completion) {
			map.put(end, map.get(end) - 1);
		}
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return "";

	}

	public static String solution1st(String[] participant, String[] completion) {
		HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
		for (int c = 0; c < completion.length; c++) {
			if (completionMap.containsKey(completion[c])) {
				completionMap.put(completion[c], completionMap.get(completion[c]) + 1);
			} else {
				completionMap.put(completion[c], 1);
			}
		}
		for (int p = 0; p < participant.length; p++) {
			if (!completionMap.containsKey(participant[p])) {
				return participant[p];
			} else {
				completionMap.put(participant[p], completionMap.get(participant[p]) - 1);
			}
		}
		for (String ans : completionMap.keySet()) {
			if (completionMap.get(ans) != 0)
				return ans;
		}
		return "";
	}

}
//
