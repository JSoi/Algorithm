package baekjoon;
import java.util.Scanner;

public class N4344 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int caseNum = scan.nextInt();
		double outputPercentage[] = new double[caseNum];
		for (int i = 0; i < caseNum; i++) {
			int hap = 0;
			int stuNum = scan.nextInt();
			int stuScores[] = new int[stuNum];
			for (int k = 0; k < stuNum; k++) {
				int eachScore = scan.nextInt();
				stuScores[k] = eachScore;
				hap += eachScore;
			}
			double avr = hap / stuNum;
			int moreThanAvr = 0;
			for (int k = 0; k < stuNum; k++) {
				if (stuScores[k] > avr) {
					moreThanAvr++;
				}
			}
			double result = ((double) moreThanAvr / (double) stuNum) * 100;
			outputPercentage[i] = Math.round(result * 1000d) / 1000d;
		}
		scan.close();
		for (int c = 0; c < caseNum; c++) {
			System.out.println(String.format("%.3f",outputPercentage[c]) + "%");
		}
	}
}
