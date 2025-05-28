package com.soi.programmers;

import java.util.*;

public class L42884 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution42884 sol = new Solution42884();
		System.out.println(sol.solution(new int[][] { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } }));
	}
}

class Solution42884 {
	ArrayList<int[]> arr;
	ArrayList<Integer> point;
	int answer;

	public int solution(int[][] routes) {
		int answer = 0;
		int camera = 300001;

		Arrays.sort(routes, (b, a) -> a[0] - b[0]);
		// ������ �������� �������� ����

		for (int[] route : routes) {
			if (route[1] < camera) { // ��輱�� �������� ī�޶� �����
				camera = route[0];
				answer++;
			}
		}
		return answer;
	}

	public int solution2(int[][] routes) { // �ð��ʰ�
		answer = Integer.MAX_VALUE;
		arr = new ArrayList<int[]>();
		point = new ArrayList<Integer>();
		for (int i = 0; i < routes.length; i++) {
			int put[] = { routes[i][0], routes[i][1] };
			if (!point.contains(routes[i][0]))
				point.add(routes[i][0]);
			if (!point.contains(routes[i][1]))
				point.add(routes[i][1]);
			arr.add(put);
		}
		Collections.sort(arr, (int[] a1, int[] a2) -> a1[1] - a2[1]);
		Collections.sort(point, (a1, a2) -> a1 - a2);
		boolean[][] passingCars = new boolean[point.size()][routes.length];
		boolean[] pass = new boolean[point.size()];
		boolean[] cars = new boolean[arr.size()];
		for (int i = 0; i < point.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j)[0] <= point.get(i) && point.get(i) <= arr.get(j)[1]) {
					passingCars[i][j] = true;
				}
			}
		}
		best(pass, cars, passingCars, 0);
		return answer;
	}

	// passing cars[point][car]
	public void best(boolean point[], boolean car[], boolean[][] passingCars, int camNum) {
		if (capAll(car)) {
			answer = Math.min(answer, camNum);
			return;
		}
		for (int i = 0; i < passingCars.length; i++) {
			if (!point[i]) {
				boolean[] tempP = new boolean[point.length];
				boolean[] tempC = new boolean[car.length];
				tempP = point.clone();
				tempC = car.clone();
				point[i] = true;
				int plusCar = 0;
				for (int j = 0; j < passingCars[0].length; j++) {
					if (passingCars[i][j]) {
						car[j] = true;
						plusCar++;
					}
				}
				best(point, car, passingCars, plusCar);
				car = tempC;
				point = tempP;
			}
		}
	}

	public boolean capAll(boolean[] v) {
		for (boolean b : v) {
			if (!b)
				return false;
		}
		return true;
	}
}