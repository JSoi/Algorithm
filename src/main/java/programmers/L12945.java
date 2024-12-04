package programmers;

public class L12945 {
	// Topic : �Ǻ���ġ ��
	// Content : n��° �Ǻ���ġ ���� 1234567�� ���� ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("answer : " + solution(4));
	}

	static int solution(int n) {
		int fibo[] = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibo[i] = ((fibo[i - 1] % 1234567) + (fibo[i - 2] % 1234567)) % 1234567;
		}
		// F(N) % 1234567 = ( F(N-1) % 1234567 + F(N-2) % 1234567 ) % 1234567
		// a = b+c
		// a % d = ((b % d)+(c % d)) % d
		return fibo[n];
	}
}
