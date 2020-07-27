package baekjoon;

import java.util.Arrays;
import java.util.HashSet;

public class L1845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 3, 1, 2, 3 }));
	}

	static int solution(int[] nums) {
		// sort �ؼ� �ٸ� ���� ã��
		Arrays.sort(nums);
		int bf = -1;
		int kind = 0;
		int choose = 0;
		for (int i = 0; i < nums.length; i++) {
			if (choose == nums.length / 2) {
				break;
			} else if (bf != nums[i]) {
				choose++;
				kind++;
			}
			bf = nums[i];
		}
		return kind;
	}

	public int solution2(int[] nums) {
		HashSet<Integer> a = new HashSet<>();
		// �ߺ��� ������� �ʴ� HashSet ���
		for (int i = 0; i < nums.length; i++) {
			a.add(nums[i]);
		}
		return (nums.length / 2 > a.size()) ? a.size() : nums.length / 2;
		/*
		 * �ߺ��� ������� �ʴ� HashSet�� ���̰� �迭 ũ���� ���� ���� �ʴ´ٸ�, HashSet�� ũ�⸦ ��ȯ �迭 ũ���� �ݺ���
		 * ũ�ٸ�(HashSet�� �ʹ� ���� ���� ���Ƿ�) �迭�� ���� �������ش�.
		 */

	}
}
