package com.soi.baekjoon;

import java.util.*;
import java.io.*;

public class N4375 {
	// 2�� 5�� ������ �������� �ʴ� ���� n(1 �� n �� 10000)�� �־����� ��, 1�θ� �̷���� n�� ����� ã�� ���α׷���
	// �ۼ��Ͻÿ�.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		int len = 0;
		while ((str = buf.readLine())!= null) {
			int n = Integer.parseInt(str);
			long val = 1;
			len=1;
			while(true) {
				if(val%n==0) {
					break;
				}
				val = (val*10)+1;
				len++;
			}
			sb.append(len+"\n");
		}
		System.out.println(sb.toString());
	}

}
