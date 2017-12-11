import java.util.Scanner;

public class N6064_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputCount = scan.nextInt();
		int[] resultBox = new int[inputCount];
		scan.nextLine();
		for (int i = 0; i < inputCount; i++) {
			String myLine = scan.nextLine();
			String[] myNum = myLine.split(" ");
			int mInput = Integer.parseInt(myNum[0]);
			int nInput = Integer.parseInt(myNum[1]);
			int xValue = Integer.parseInt(myNum[2]);
			int yValue = Integer.parseInt(myNum[3]);
			resultBox[i] = result(mInput, nInput, xValue, yValue);
		}
		for (int p = 0; p < inputCount; p++) {	
			System.out.println(resultBox[p]);
		}
		scan.close();
	}

	public static int result(int m, int n, int x, int y) {
		int calResult = -1;
		int lcmValue = lcm(m, n);
		for (int mi = 0; mi < lcmValue / m; mi++) {
			for (int ni = 0; ni < lcmValue / n; ni++) {
				if (m * mi + x == n * ni + y) {
					calResult = m * mi + x;
					return calResult;
				}
			}
		}
		return calResult;
	}
	
	static int lcm(int a, int b) {
		int tempa = a;
		int tempb = b;
		while (tempb != 0)
			if (tempa > tempb)
				tempa -= tempb;
			else
				tempb -= tempa;
		return a * b / tempa;
	}
}