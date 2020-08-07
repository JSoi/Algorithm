package programmers;

import java.util.*;

public class L42897 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution42897 sol = new Solution42897();
		System.out.println(sol.solution(new int[] { 100, 1, 1, 100, 1 }));
	}

}

class Solution42897 {
	int answer = 0;

	public int solution(int[] money) { // 시간초과
		steal(money, new boolean[money.length], 0, 0, 0);
		return answer;
	}

	public void steal(int[] money, boolean[] sorn, int index, int stealCount, int stealMoney) {
		if (!stealOK(sorn))
			return;
		if (stealCount >= (money.length / 2) + money.length % 2) {
//			System.out.println(Arrays.toString(sorn));
			answer = Math.max(answer, stealMoney);
			return;
		}
		for (int i = index; i < money.length; i++) {
			if (!sorn[i]) {
				sorn[i] = true;
				steal(money, sorn, index + 1, stealCount + 1, stealMoney + money[i]);
				sorn[i] = false;
				steal(money, sorn, index + 1, stealCount, stealMoney);
			}
		}
	}

	public boolean stealOK(boolean[] sorn) {
		for (int i = 0; i < sorn.length; i++) {
			int left = (i - 1 >= 0) ? (i - 1) : (sorn.length - 1);
			int right = (i + 1) < sorn.length ? (i + 1) : 0;
			if (sorn[i]) {
				if (sorn[left] || sorn[right]) {
					return false;
				}
			}
		}
		return true;
	}
}
