package com.soi.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L62049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(3);
	}

	static int[] solution(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		for (int i = 2; i <= n; i++) {
			Queue<Integer> temp = new LinkedList<Integer>();
			temp.offer(1);
			int ab = 0;
			while (!q.isEmpty()) {
				int d = q.poll();
				temp.offer(d);
				temp.offer(ab);
				ab = (ab == 0 ? 1 : 0);
			}
			q = temp;
		}
		int[] answer = new int[q.size()];
		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = q.poll();
//			System.out.println(answer[i]);
		}
		return answer;
	}
}
