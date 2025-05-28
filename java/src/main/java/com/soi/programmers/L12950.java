package com.soi.programmers;

public class L12950 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = new int[][] { { 1, 2, 3 }, { 2, 3,5 } };
		int b[][] = new int[][] { { 1, 2, 3 }, { 2, 3,5 } };
		int c[][] = solution(a, b);
		for (int[] te : c) {
			for (int tet : te) {
				System.out.println(tet);
			}
		}
		System.out.println();
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		System.out.println("test : " + arr1.length);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
}
