package programmers;

public class L12899 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(11));

	}

	public static String solution(long n) {
		String answer = "";
		int div = 3;
		while (n > 0) {
			if (n % 3 == 0) {// 3
				answer = 4 + answer;
			} else if (n % 3 == 1) {// 1
				answer = 1 + answer;
			} else {// 2
				answer = 2 + answer;
			}
			if (n % 3 == 0) {
				n = n / 3 - 1;
			} else {
				n = n / 3;
			}
			//System.out.println("testN : " + n);
			//System.out.println("testanswer : " + answer);
		}
		answer = "" + Long.valueOf(answer);
		return answer;
	}
}
