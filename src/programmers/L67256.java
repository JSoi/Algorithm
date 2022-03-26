package programmers;

public class L67256 {
	public static void main(String[] args) {
	}

	public String solution(int[] numbers, String hand) {
		int[][] arrL = new int[10][10];
		int[][] arrR = new int[10][10];
		arrL[2][1] = arrL[5][4] = arrL[8][7] = arrR[2][3] = arrR[5][6] = arrR[8][9] = 1;
		arrL[2][4] = arrL[5][1] = arrL[5][7] = arrL[8][4] = arrR[2][6] = arrR[5][6] = arrR[5][9] = arrR[8][6] = 2;
		arrL[2][1] = arrL[8][1] = arrR[2][9] = arrR[8][3] = 3;
		int handL = 0, handR = 0;
		if (hand.equals("left")) {
			handR = 1;
		} else {
			handL = 1;
		}
		String answer = "";
		return answer;
	}
}
