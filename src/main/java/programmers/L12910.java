package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class L12910 {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		if (list.size() == 0) {
			int ans[] = { -1 };
			return ans;
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		int c = 0;
		for (int a : list) {
			answer[c++] = a;
		}
		return answer;
	}
}
