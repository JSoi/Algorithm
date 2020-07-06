package programmers;

import java.util.HashMap;

public class L42578 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } }));
	}

	// Hashmap+ Permutation
	public static int solution(String[][] clothes) {
		int answer = 0;
		int arrc = 0;
		HashMap<String, Integer> Closet = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			Closet.put(clothes[i][1], Closet.getOrDefault(clothes[i][1], 0) + 1);
		}
		String closetArr[] = new String[Closet.size()];
		for (String cloth : Closet.keySet()) {
			closetArr[arrc] = cloth;
			arrc += 1;
		}
		for (int i = 0; i < Closet.size(); i++) {
			answer += giveCountsbySize(closetArr, i, Closet);
		}
		return answer;
	}

	public static int giveCountsbySize(String closetArr[], int index, HashMap<String, Integer> Closet) {
		int ans = Closet.get(closetArr[index]);
		if (index == Closet.size() - 1)
			return ans;
		int plus = 0;
		for (int p = index + 1; p < Closet.size(); p++) {
			plus += giveCountsbySize(closetArr, p, Closet);
		}
		return ans *= 1 + plus;
	}
}
