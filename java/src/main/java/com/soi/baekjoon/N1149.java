package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N1149 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(buf.readLine());
		int[][] cost = new int[cnt][3];
		for (int i = 0; i < cnt; i++) {
			String line = buf.readLine();
			StringTokenizer tok = new StringTokenizer(line, " ");
			cost[i][0] = Integer.parseInt(tok.nextToken());
			cost[i][1] = Integer.parseInt(tok.nextToken());
			cost[i][2] = Integer.parseInt(tok.nextToken());
		}
		
		for (int i = 1; i < cnt; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		System.out.println(Math.min(Math.min(cost[cnt - 1][0], cost[cnt - 1][1]), cost[cnt - 1][2]));
	}

	/**
	 * 1�� ���� ���� 2�� ���� ���� ���� �ʾƾ� �Ѵ�. N�� ���� ���� N-1�� ���� ���� ���� �ʾƾ� �Ѵ�. i(2 �� i �� N-1)��
	 * ���� ���� i-1��, i+1�� ���� ���� ���� �ʾƾ� �Ѵ�.
	 */
}
