package programmers;

public class L12977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 7, 6, 4 }));
	}

	static int solution(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (sosu(nums[i] + nums[j] + nums[k])) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	static boolean sosu(int input) {
		if (input == 1)
			return false;
		if (input == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(input); i++) {
			if (input % i == 0)
				return false;
		}
		return true;
	}
}
