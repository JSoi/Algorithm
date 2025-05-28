package com.soi.programmers;

import java.util.*;

public class L43238 {
	public long solution(int n, int[] times) {
		long answer = 0;
		if (n < times.length)
			return n;
		Arrays.sort(times);
		long low = 1;
		long high = (long) times[times.length - 1] * (long) n;

		while (low <= high) {
			long mid = (low + high) / 2;
			long cnt = 0;

			for (int i = 0; i < times.length; i++) {
				cnt += mid / times[i];
			}

			if (cnt >= n) {
				if (answer == 0)
					answer = mid;
				else
					answer = Math.min(answer, mid);
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return answer;
	}

}