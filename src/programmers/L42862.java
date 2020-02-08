package programmers;

public class L42862 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int st[] = new int[n + 2];
		for (int k = 1; k <= n; k++) {
			st[k] = 1;
		}

		for (int k = 0; k < reserve.length; k++) {
			st[reserve[k]]++;
		}
		for (int k = 0; k < lost.length; k++) {
			st[lost[k]]--;
		}
		for (int k = 1; k <= n; k++) {
			if (st[k] == 0) {
				if (st[k - 1] == 2) {
					st[k - 1]--;
					st[k]++;
				} else if (st[k + 1] == 2) {
					st[k + 1]--;
					st[k]++;
				}
			}
		}
		int answer = n;
		for (int k = 1; k <= n; k++) {
			if (st[k] == 0) {
				answer--;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 4 }; // 0 1 1 1 0 1 0
		int[] b = { 3 };
		System.out.println(solution(5, a, b));
	}

}
