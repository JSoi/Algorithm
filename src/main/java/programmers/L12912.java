package programmers;

public class L12912 {
	public long solution(int a, int b) {
		if (a == b)
			return a;
		int k = 0;
		if (a > b) {
			k = b;
			b = a;
			a = k;
		}
		long answer = 0;
		for (int i = a; i <= b; i++) {
			answer += i;
		}
		return answer;
	}
}
