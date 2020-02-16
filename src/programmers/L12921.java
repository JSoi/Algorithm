package programmers;

public class L12921 {
	public int solution(int n) {
		int answer = 0;
		boolean check[] = new boolean[n + 1];
		check[0] = check[1] = false;
		for (int i = 2; i <= n; i++) {
			check[i] = true;
		}
		for (int i = 2; i * i <= n; i += 1) {
			for (int j = i * i; j <= n; j += i) {
				check[j] = false;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (check[i])
				answer++;
		}
		return answer;
	}
}
