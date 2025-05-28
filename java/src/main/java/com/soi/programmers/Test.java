package com.soi.programmers;

public class Test {

	public static void main(String[] args) {
		L12918 test = new L12918();
		System.out.println(test.solution("a123"));
		System.out.println(test.solution("1234"));
	}
	

	public static void mainL12916(String[] args) {
		L12916 test = new L12916();
		System.out.println(test.solution("Pyy"));
	}


	public static void mainL12915(String[] args) {
		L12915 test = new L12915();
		String arr[] = { "abce", "abcd", "cdx" };
		String ans[] = test.solution(arr, 2);
		for (String a : ans) {
			System.out.print(a + " ");
		}
	}

	public static void main12912(String[] args) {
		L12912 test = new L12912();
		System.out.println(test.solution(3, 5));
	}

	public static void main126910(String[] args) {
		L12910 test = new L12910();
		int arr[] = { 5, 9, 7, 10 };
		int[] answer = test.solution(arr, 5);
		for (int a : answer) {
			System.out.println(a);
		}
	}
}
