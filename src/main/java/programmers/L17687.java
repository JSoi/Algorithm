package programmers;

public class L17687 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(16, 16, 2, 2));
	}

	static String solution(int n, int number, int ppl, int turn) {
		// 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
		String game[] = new String[ppl];
		// turn-1 = index
		String totalLine = makeLine(n, (number + 1) * ppl);
		char totalLineArr[] = totalLine.toCharArray();
		for (int i = 0; i < totalLineArr.length; i++) {
//			System.out.println("game[turn-1] : " + game[turn - 1]);
			if (game[turn - 1] != null && game[turn - 1].length() == number) {
				return game[turn - 1];
			}
			if (game[i % ppl] == null) {
				game[i % ppl] = totalLineArr[i] + "";
			} else {
				game[i % ppl] += totalLineArr[i];
			}
		}
		return "";
	}

	static String makeLine(int n, int max) {
		// ppl*number
		String line = "";
		for (int i = 0; line.length() < max; i++) {
			line += makeNum(n, i);

		}
		return line;

	}

	static String makeNum(int n, int num) {
		String line = "";
		String bigNum[] = new String[16];
		bigNum[10] = "A";
		bigNum[11] = "B";
		bigNum[12] = "C";
		bigNum[13] = "D";
		bigNum[14] = "E";
		bigNum[15] = "F";

		if (num == 0)
			return "0";
		while (num > 0) {
			line = (num % n > 9 ? bigNum[num % n] : num % n) + line;
			num /= n;
		}
		return line;
	}
}
