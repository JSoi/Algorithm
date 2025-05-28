package com.soi.baekjoon;
import java.util.Scanner;

public class N1011 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputCount = scan.nextInt();
		int[] resultBox = new int[inputCount];
		for (int i = 0; i < inputCount; i++) {
			scan.nextLine();
			int xValue = scan.nextInt();
			int yValue = scan.nextInt();
			resultBox[i] = calTime(xValue, yValue);
		}
		for (int p = 0; p < inputCount; p++) {
			System.out.println(resultBox[p]);
		}
		scan.close();
	}

	public static int calTime(int start, int end) {
		int bet = end - start;
		int middleResult = 0;
		int realResult = 0;
		int countOver;
		double compare = Math.sqrt(bet + 0.25) - 0.5;
		int i = 0;
		while (true) {
			if (i > compare) {
				middleResult = i - 1;
				break;
			} else {
				i++;
			}
		}
		countOver = bet - (middleResult * (middleResult + 1));
		if (countOver % (middleResult + 1) == 0) {
			realResult = middleResult * 2 + countOver / (middleResult + 1);
		} else {
			realResult = middleResult * 2 + countOver / (middleResult + 1) + 1;
		}
		return realResult;
	}
}
