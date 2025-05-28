package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8394 {
	// �Ǻ���ġ ����
	// d[n] = d[n-1] + d[n-2]
	// �Ǽ��� ����� �� = �Ǽ��� �ϴ� ��� + �Ǽ��� ���� �ʴ� ���
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int input = Integer.parseInt(line);
		int d[] = new int[input + 1];
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i < d.length; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 10;
		}
		System.out.println(d[input]);
	}

}
