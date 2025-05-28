package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N11003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int l = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(buf.readLine());
		Deque<Node> dq = new LinkedList<Node>();
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(tok.nextToken());
			while (!dq.isEmpty() && dq.getLast().value > val) {
				dq.removeLast();
			}
			dq.addLast(new Node(val, i));
			if (dq.getFirst().index <= i - l) {
				dq.removeFirst();
			}
			bw.write(dq.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}

	static class Node {
		int value;
		int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
