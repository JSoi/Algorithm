package programmers;

public class L12603 {
	public static String solution(String s) {
		int length = s.length();
		int mid = (int) (length / 2);
		if (length == 1)
			return s;
		if (length % 2 == 0)
			return "" + s.charAt(mid - 1) + s.charAt(mid);
		return s.charAt(mid) + "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("hellow"));
	}

}
