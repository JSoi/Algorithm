package programmers;

public class L43165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	static int[] numArr;
	static int fAnswer;
	static int fTarget;

	public static int solution(int[] numbers, int target) {
		fAnswer = 0;
		fTarget = target;
		numArr = numbers.clone();
		solve(0, 0);
		return fAnswer;
	}

	public static void solve(int index, int value) {
		if (index == numArr.length) {
			if (fTarget == value) {
				fAnswer++;
			}
		} else {
			solve(index + 1, value - numArr[index]);
			solve(index + 1, numArr[index] + value);
		}
	}

}
