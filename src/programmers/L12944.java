package programmers;

public class L12944 {
	public double solution(int[] arr) {
		long hap = 0;
		for (int i = 0; i < arr.length; i++) {
			hap += arr[i];
		}
		double answer = (double) hap / arr.length;
		return answer;
	}
}
