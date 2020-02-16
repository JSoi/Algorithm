package programmers;

public class L12940 {
	public int[] solution(int n, int m) {
		int answer[] = new int[] { GCD(n, m), n * m / GCD(n, m) };
		return answer;
	}

	public int GCD(int a, int b) {
		return b == 0 ? a : GCD(b, a % b);
	}
}
