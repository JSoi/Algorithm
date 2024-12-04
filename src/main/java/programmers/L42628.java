package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class L42628 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42628 sol = new Solution_42628();
		System.out.println(sol.solution2(new String[] { "I 16", "D 1" }));
		System.out.println(sol.solution2(new String[] { "I 7", "I 5", "I -5", "D -1" }));
	}

}

class Solution_42628 {
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (String str : operations) {
			String operator = str.split(" ")[0];
			int number = Integer.parseInt(str.split(" ")[1]);
//			System.out.println(operator + " / " + number);
			if (operator.equals("I")) {
				ans.add(number);
				Collections.sort(ans, (a1, a2) -> a1 - a2);
//				System.out.println("Check : ");
//				System.out.println(ans.toString());
				continue;
			}
//			System.out.println(ans.toString());
			if (number == -1 && operator.equals("D") && !ans.isEmpty()) {
				ans.remove(0);
			} else if (number == 1 && operator.equals("D") && !ans.isEmpty()) { // 최대값 삭제
				ans.remove(ans.size() - 1);
			}
		}
		if (!ans.isEmpty()) {
			answer[1] = ans.get(0);
			answer[0] = ans.get(ans.size() - 1);
		}
//		print(answer);
		return answer;
	}

	public void addArr(ArrayList<Integer> arr, int input) {
		for (int i = 0; i < arr.size(); i++) {
			if (input >= arr.get(i)) {
				arr.add(i);
				return;
			}
		}
		arr.add(input);
	}

	public int[] solution2(String[] operations) { // 큐로 구현
		int[] answer = { 0, 0 };
		Queue<Integer> q = new PriorityQueue<Integer>();
		Queue<Integer> rq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (String str : operations) {
			String operator = str.split(" ")[0];
			int number = Integer.parseInt(str.split(" ")[1]);
			if (operator.equals("I")) {
				q.offer(number);
				rq.offer(number);
				continue;
			}
			if (number == -1 && operator.equals("D") && !q.isEmpty() ) {
				int min = q.poll();
				rq.remove(min);
			} else if (number == 1 && operator.equals("D") && !rq.isEmpty() ) { // 최대값 삭제
				int max = rq.poll();
				q.remove(max);
			}
		}
		if (q.size() >= 2) {
			answer[0] = rq.peek();
			answer[1] = q.peek();
		}
//		print(answer);
		return answer;
	}

	public void print(int[] a) {
		for (int v : a) {
			System.out.println(v);
		}
	}
}