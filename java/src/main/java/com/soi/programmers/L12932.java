package com.soi.programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class L12932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		int ans[] = solution(n);
		for(int o : ans) {
			System.out.print(o + " ");
		}
	}

	public static int[] solution(long n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (n > 0) {
			list.add((int) (n % 10));
			n /= 10;
		}
		int[] answer = new int[list.size()];
		int count = 0;
		for (int i : list) {
			answer[count++] = i;
		}
		return answer;
	}
}
