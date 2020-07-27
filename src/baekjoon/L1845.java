package baekjoon;

import java.util.Arrays;
import java.util.HashSet;

public class L1845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 3, 1, 2, 3 }));
	}

	static int solution(int[] nums) {
		// sort 해서 다른 값을 찾기
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
		// 중복을 허용하지 않는 HashSet 사용
		for (int i = 0; i < nums.length; i++) {
			a.add(nums[i]);
		}
		return (nums.length / 2 > a.size()) ? a.size() : nums.length / 2;
		/*
		 * 중복을 허용하지 않는 HashSet의 길이가 배열 크기의 반이 되지 않는다면, HashSet의 크기를 반환 배열 크기의 반보다
		 * 크다면(HashSet에 너무 많은 수가 들어가므로) 배열의 반을 리턴해준다.
		 */

	}
}
