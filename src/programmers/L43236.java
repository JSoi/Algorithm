package programmers;

import java.util.*;

public class L43236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43236 sol = new Solution43236();
		System.out.println(sol.solution(16, new int[] { 4, 8, 11 }, 2));
	}

}

class Solution43236 {
	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		int answer = 0;
		int l = 1;
		int r = distance;
		int minus = 0;
		int mid;
		int bf = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			for (int i = 0; i < rocks.length; i++) {
				if (mid > rocks[i] - bf) {
					minus++;
				} else {
					bf = rocks[i];
				}
			}
			if (mid > distance - bf) {
				minus++;
			}
			if (minus > n) {
				r = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				l = mid + 1;
			}
			minus = 0;
			bf = 0;
		}
		return answer;
	}

	public int solution2(int distance, int[] rocks, int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int r : rocks) {
			arr.add(r);
		}
		arr.add(0);
		arr.add(distance);
		Collections.sort(arr);
		ArrayList<Integer> d = new ArrayList<Integer>();
		for (int i = 1; i < arr.size(); i++) {
			d.add(arr.get(i) - arr.get(i - 1));
		}
		while (n > 0) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = d.size() - 1; i >= 0; i--) {
				if (min > d.get(i)) {
					minIndex = i;
					min = d.get(i);
				}
			}
			if (minIndex + 1 >= d.size()) {
				minIndex--;
			} else if (minIndex - 1 >= 0 && d.get(minIndex + 1) >= d.get(minIndex - 1)) {
				minIndex--;
			}
			int a = d.remove(minIndex);
			int b = d.remove(minIndex);
			d.add(minIndex, a + b);
			n--;
		}
		Collections.sort(d);
		return d.get(0);
	}
}