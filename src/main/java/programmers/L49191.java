package programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class L49191 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
	}

	public static int solution(int n, int[][] results) {
		// A>B
		ArrayList<N> playerlist = new ArrayList<N>();
		for (int i = 0; i <= n; i++) {
			playerlist.add(new N(i));
		}
		for (int result[] : results) {
			playerlist.get(result[0]).win(result[1]);
			playerlist.get(result[1]).lost(result[0]);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				N target = playerlist.get(j);
				HashSet<Integer> smalltemp = new HashSet<Integer>();
				HashSet<Integer> bigtemp = new HashSet<Integer>();
				for (int big : target.bigset) {
					bigtemp.addAll(playerlist.get(big).bigset);
				}
				for (int small : target.smallset) {
					smalltemp.addAll(playerlist.get(small).smallset);
				}
				target.smallset.addAll(smalltemp);
				target.bigset.addAll(bigtemp);
			}
		}
		int answer = 0;
		for (N p : playerlist) {
			if (p.bigset.size() + p.smallset.size() == n - 1) {
				answer++;
			}
		}
		return answer;
	}

}

class N {
	int num;
	HashSet<Integer> bigset = new HashSet<Integer>();
	HashSet<Integer> smallset = new HashSet<Integer>();

	public N(int input) {
		this.num = input;
	}

	public void lost(int input) {
		bigset.add(input);
	}

	public void win(int input) {
		smallset.add(input);
	}
}
