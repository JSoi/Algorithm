package programmers;

import java.util.*;

public class L43164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43164 sol = new Solution43164();
		Solution43164 sol2 = new Solution43164();
		Solution43164 sol3 = new Solution43164();
		Solution43164 sol4 = new Solution43164();
//		sol.solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		sol2.solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } });
//		sol3.solution(new String[][] { { "ICN", "A" }, { "ICN", "B" }, { "B", "ICN" } });
//		sol4.solution(new String[][] { { "ICN", "COO" }, { "COO", "ICN" }, { "ICN", "COO" } });
	}

}

class Solution43164 {
	ArrayList<String> ansarr = new ArrayList<String>();
	ArrayList<String> airport = new ArrayList<String>();

	public String[] solution(String[][] tickets) {
		for (int i = 0; i < tickets.length; i++) {
			if (!airport.contains(tickets[i][0]))
				airport.add(tickets[i][0]);
			if (!airport.contains(tickets[i][1]))
				airport.add(tickets[i][1]);
		}
		Collections.sort(airport, (a1, a2) -> a1.compareTo(a2));
		int visit[][] = new int[airport.size()][airport.size()];
		for (int i = 0; i < tickets.length; i++) {
			visit[airport.indexOf(tickets[i][0])][airport.indexOf(tickets[i][1])]++;
		}
		addAns(visit, airport.indexOf("ICN"));

		// String[] array = ansarr.stream().toArray(String[]::new);
		String[] answer = ansarr.stream().toArray(n -> new String[n]);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public void addAns(int[][] visit, int target) {
		ansarr.add(airport.get(target));
		ArrayList<Integer> order = new ArrayList<Integer>();
		for (int i = 0; i < visit[0].length; i++) {
			if (visit[target][i] > 0 && i != target) {
				order.add(i);
			}
		}
		if (order.isEmpty())
			return;
		Collections.sort(order, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				boolean b1 = isEmpty(visit, o1);
				boolean b2 = isEmpty(visit, o2);
				System.out.println("a1 : " + o1 + " / b1 : " + b1);
				System.out.println("a1 visit : " + Arrays.toString(visit[o1]));
				System.out.println("a2 : " + o2 + " / b2 : " + b2);
				System.out.println("a2 visit : " + Arrays.toString(visit[o2]));
				if (b1 && b2 || !b1 && !b2) {
					return o1.compareTo(o2);
				} else if (b1 && !b2) {
					return 1;
				} else if (!b1 && b2) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		System.out.println(order.toString());
		for (int k : order) {
			addAns(visit, k);
		}
	}

	public boolean isEmpty(int[][] visit, int target) {
		for (int i = 0; i < visit[0].length; i++) {
			if (visit[target][i] > 0) {
				return false;
			}
		}
		return true;
	}
}
