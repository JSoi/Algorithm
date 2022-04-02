package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L72411 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] order = new String[] { "XYZ", "XWY", "WXA" };
		int[] course = new int[] { 2, 3, 4 };
		String[] sol = solution(order, course);
		System.out.println(Arrays.toString(sol));
	}

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		for (int k = 0; k < orders.length; k++) {
			char[] temp = orders[k].toCharArray();
			Arrays.sort(temp);
			orders[k] = new String(temp);
		}
		mini m = new mini(orders, course);
		m.comb();
		answer = new String[m.answerSet.size()];
		int ac = 0;
		for (String s : m.answerSet) {
			answer[ac++] = s;
		}
		Arrays.sort(answer);
		return answer;
	}

	public static class mini {
		String[] orders;
		int[] course;
		HashMap<String, Integer> map;
		HashSet<String> answerSet;

		public mini(String[] orders, int[] course) {
			this.orders = orders;
			this.course = course;
			answerSet = new HashSet<String>();
		}

		public void comb() {
			for (int c : course) { // »Ì´Â °¡Áö¼ö
				map = new HashMap<String, Integer>();
				for (String order : orders) {
					char[] arrC = order.toCharArray();
					boolean[] visited = new boolean[arrC.length];
					if (c > order.length()) {
						continue;
					}
					com("", arrC, visited, 0, arrC.length, c);
				}
				int maxKey = 0;
				for (String str : map.keySet()) {
					maxKey = Math.max(map.get(str), maxKey);
				}
				if (maxKey < 2) {
					continue;
				}
				for (String str : map.keySet()) {
					if (map.get(str) == maxKey) {
						answerSet.add(str);
					}
				}
				System.out.println(map.toString());
			}
		}

		public void com(String s, char[] arr, boolean[] visited, int start, int n, int r) {
			if (r == 0) {
				map.put(s, map.getOrDefault(s, 0) + 1);
				return;
			}
			for (int i = start; i < n; i++) {
				visited[i] = true;
				com(s + arr[i], arr, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
		}
	}

}
