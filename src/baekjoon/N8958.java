package baekjoon;
import java.util.Scanner;

public class N8958 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int time = scan.nextInt();
		int result[] = new int[time];
		scan.nextLine();
		for (int i = 0; i < time; i++) {
			String line = scan.nextLine();
			char inputs[] = line.toCharArray();
			int score = 0;
			int plusScore = 0;
			for (int k = 0; k < inputs.length; k++) {
				if (inputs[k] == 'O') {
					if (plusScore == 0) { // ���ӵ� ��찡 �ƴҶ�
						score += 1;
						plusScore = 1;
					} else { // ���ӵ� ����϶�
						plusScore++;
						score += plusScore;
					}
				} else {
					plusScore = 0;
				}
			}
			result[i] = score;
		}
		for (int k = 0; k < result.length; k++) {
			System.out.println(result[k]);
		}
		scan.close();
	}
}
