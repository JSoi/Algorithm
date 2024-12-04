package baekjoon;
import java.util.Scanner;

public class N2675 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int caseNum = scan.nextInt();
		String[] output = new String[caseNum];
		for (int i = 0; i < caseNum; i++) {
			int repeat = scan.nextInt();
			String line = scan.next();
			char[] lineArray = line.toCharArray();
			String dupResult = "";
			for (int k = 0; k < lineArray.length; k++) {
				for (int r = 0; r < repeat; r++) {
					dupResult += lineArray[k];
				}
			}
			output[i] = dupResult;
		}
		for(int p = 0; p < output.length; p++) {
			System.out.println(output[p]);
		}
		scan.close();
	}
}
