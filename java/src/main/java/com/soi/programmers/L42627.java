package com.soi.programmers;

import java.util.*;

public class L42627 implements Comparable<L42627> {
	int putTime;
	int progressTime;

	L42627(int a, int b) {
		this.putTime = a;
		this.progressTime = b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));

	}

	static int solution(int[][] jobs) {
		int answer = 0;
		int time = 0;

		ArrayList<L42627> arr = new ArrayList<L42627>();
		for (int[] j : jobs) {
			arr.add(new L42627(j[0], j[1]));
		}
		Collections.sort(arr, (L42627 o1, L42627 o2) -> o1.putTime - o2.putTime);
		PriorityQueue<L42627> q = new PriorityQueue<L42627>((o1, o2) -> o1.progressTime - o2.progressTime);

		// printQ(arr);
		while (!arr.isEmpty() || !q.isEmpty()) {
			while (!arr.isEmpty() && arr.get(0).putTime <= time) {
				q.offer(arr.remove(0));
			}
			if (q.isEmpty()) {
				time = arr.get(0).putTime;
			} else {
				L42627 target = q.poll();
				answer += (time - target.putTime + target.progressTime);
				time += target.progressTime;
			}
		}
		return answer / jobs.length;
	}

	@Override
	public int compareTo(L42627 other) {
		if (this.progressTime < other.progressTime)
			return -1;
		else if (this.progressTime > other.progressTime)
			return 1;
		else
			return 0;
	}

	public static void printQ(ArrayList<L42627> q) {
		for (L42627 s : q) {
			System.out.println("putTime : " + s.putTime + " progressTime : " + s.progressTime);
		}
	}
}
