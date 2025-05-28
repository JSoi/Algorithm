package com.soi.baekjoon;
import java.util.Scanner;

public class N1316 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lineNum = scan.nextInt();
		scan.nextLine();
		int gNum = 0;
		for (int i = 0; i < lineNum; i++) {
			String line = scan.nextLine();
			if (group(line)) { // �����Ŷ� �ٸ���!
				gNum++;
			}
		}
		System.out.println(gNum);
		scan.close();
	}

	public static boolean group(String input) {
		boolean tf = true;
		char[] inputArr = input.toCharArray();
		boolean[] alpC = new boolean[26];
		for (int k = 0; k < alpC.length; k++) { // �ʱ�ȭ
			alpC[k] = false; // �߰ߵ��� �ʾҴ�! ó���̴� ��� false ǥ��
		}
		char check = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] != check) { // �Ȱ��� ���ڰ� �ƴ� ��쿡�� �׷� ���� üũ�ؾ� �ȴ�!
				if(!alpC[(int)inputArr[i]-97]) { // ó������_false, ����
					check = inputArr[i];
					alpC[(int)inputArr[i]-97] = true; // �߰��ߴٰ� üũ!
				}
				else { // ���ʰ� �ƴϴ� _> �׷�ܾ� �������� ����
					tf = false;
					break;
				}
			}
		}
		return tf;
	}
}
