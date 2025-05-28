package com.soi.baekjoon;

import java.util.Scanner;
/**
 * @author Soi
 * @�������� ������ �־����� ��, �����̸� 1, �ƴϸ� 0�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ������ ������ 4�� ����̸鼭, 100�� �����
 *       �ƴ� �� �Ǵ� 400�� ����� �� �̴�. �������, 2012���� 4�� ����� ����������, 1900���� 4�� ���������,
 *       100�� ����̱� ������ ������ �ƴϴ�. ������, 2000���� 400�� ����̱� ������ �����̴�
 */
public class N2753 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		if ((input % 4 == 0 && input % 100 != 0) || (input % 400 == 0))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
