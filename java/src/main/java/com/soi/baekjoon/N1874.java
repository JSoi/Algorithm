package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1874 {
	static Stack<Integer> st = new Stack<Integer>();
	static StringBuffer sb = new StringBuffer();
	static int now = 0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(buf.readLine());
		for (int i = 0; i < cnt; i++) {
			go(Integer.parseInt(buf.readLine()));
			if(flag) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());
	}

	static void go(int index) {
		if (now < index) {
			while (now < index) {
				now++;
				st.push(now);
				sb.append("+\n");
			}
			st.pop();
			sb.append("-\n");
		} else {
			int pop = st.pop();
			if (index != pop) {
				flag = true;
				return;
			} else {
				sb.append("-\n");
			}
		}
	}

}
