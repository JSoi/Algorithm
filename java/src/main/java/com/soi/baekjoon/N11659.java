package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11659 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer token = new StringTokenizer(buf.readLine());
		int cnt = Integer.parseInt(token.nextToken());
		int lineCnt = Integer.parseInt(token.nextToken());
		long[] hap = new long[cnt + 1];
		token = new StringTokenizer(buf.readLine());

		for (int i = 1; i <= cnt; i++) {
			hap[i] = hap[i - 1] + Integer.parseInt(token.nextToken());
		}
		for (int i = 0; i < lineCnt; i++) {
			token = new StringTokenizer(buf.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			System.out.println(hap[end] - hap[start - 1]);
		}

	}

}
