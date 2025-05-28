package com.soi.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// https://codingjuny.tistory.com/35 ����
public class L42890 {

	static int myans;
	static ArrayList<HashSet<Integer>> candidate;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myans = 0;

		System.out.println(solution(new String[][] { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } }));

	}

	static int solution(String[][] relation) {
		candidate = new ArrayList<HashSet<Integer>>();
		for (int i = 1; i <= relation[0].length; i++) {
			boolean visit[] = new boolean[relation[0].length];
			allCandidate(relation, 0, 0, i, visit);
		}
		return candidate.size();
	}

	static void allCandidate(String[][] relation, int index, int count, int countMax, boolean[] visit) {
		if (count == countMax) {
			if (unique(relation, visit)) {
				HashSet<Integer> set = new HashSet<Integer>();
				for (int i = 0; i < visit.length; i++) {
					if (visit[i]) {
						set.add(i);
					}
				}
				for (HashSet<Integer> key : candidate) {
					if (set.containsAll(key)) {
						return;
					}
				}
				candidate.add(set);
			}
			return;
		}
		for (int i = index; i < relation[0].length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				allCandidate(relation, i + 1, count + 1, countMax, visit);
				visit[i] = false;
			}
		}
	}

	static boolean unique(String[][] relation, boolean go[]) {
		ArrayList<String> ch = new ArrayList<String>();
		for (int i = 0; i < relation.length; i++) {
			String s = "";
			for (int j = 0; j < relation[0].length; j++) {
				if (go[j]) {
					s += relation[i][j] + " ";
				}
			}
			s = s.trim();
			if (ch.contains(s))
				return false;
			ch.add(s);
		}
		return true;
	}

}
