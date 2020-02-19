package programmers;

public class L17682 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("1S2D*3T");
	}

	public static int solution(String dartResult) {
		int numC = 0;
		int totalNum = dartResult.split("S|D|T").length;
		int[] resultArr = new int[totalNum];
		String temp = "";
		for (int i = 0; i < dartResult.length(); i++) {
			char now = dartResult.charAt(i);
			if (now == 'S') {
				
			} else if (now == 'D') {

			} else if (now == 'T') {

			} else if (now == '#') {

			} else if (now == '*') {

			} else {
				temp += dartResult.charAt(i);
			}
		}
		int answer = 0;
		return answer;
	}
}
