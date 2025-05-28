package com.soi.programmers;

public class L43163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43163 sol = new Solution43163();
//		System.out.println(sol.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(sol.solution("hot", "wow", new String[] { "hot", "dog", "dot", "wow" }));
	}

}

class Solution43163 {
	int answer;
	boolean[][] connect;
	int targetIndex;

	public int solution(String begin, String target, String[] words) {
		answer = Integer.MAX_VALUE;
		targetIndex = -1;
		int beginIndex = -1;
		for (int j = 0; j < words.length; j++) {
			if (words[j].equals(target)) {
				targetIndex = j;
			}
			if (words[j].equals(begin)) {
				beginIndex = j;
			}
		}
		if (targetIndex == -1)
			return 0;
		int len = beginIndex == -1 ? words.length + 1 : words.length;
		beginIndex = beginIndex == -1 ? words.length : beginIndex;
		connect = new boolean[len][len];
		boolean[] visit = new boolean[len];
		visit[beginIndex] = true;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				connect[i][j] = similar(words[i], words[j]);
			}
		}
		for (int i = 0; i < words.length; i++) {
			boolean s = similar(begin, words[i]);
			connect[i][beginIndex] = s;
			connect[beginIndex][i] = s;
		}
		search(beginIndex, visit, 0);
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		return answer;
	}

	public void search(int index, boolean[] visit, int move) {
//		System.out.println(Arrays.toString(visit));
		if (index == targetIndex) {
			answer = Math.min(answer, move);
			return;
		}
		if (allV(visit) && answer == Integer.MAX_VALUE) {
			answer = 0;
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i] && connect[index][i]) {
				visit[index] = true;
				search(i, visit, move + 1);
				visit[index] = false;
			}
		}
		return;
	}

	public boolean allV(boolean[] visit) {
		for (boolean v : visit) {
			if (!v)
				return false;
		}
		return true;
	}

	public boolean similar(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i))
				count++;
		}
		if (count == a.length() - 1)
			return true;
		else
			return false;
	}
}