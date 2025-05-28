package com.soi.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class L42579 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 })));
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<album> genreplayList = new ArrayList<album>();
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		for (String key : map.keySet()) {
			genreplayList.add(new album(key, 0, map.get(key)));
		}
		Collections.sort(genreplayList);
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		for (album a : genreplayList) {
			ArrayList<album> tempList = new ArrayList<album>();
			for (int i = 0; i < genres.length; i++) {
				if (a.genre.equals(genres[i])) {
					tempList.add(new album(a.genre, i, plays[i]));
				}
			}
			Collections.sort(tempList);
			int count = 2;
			while (count > 0) {
				answerList.add(tempList.remove(0).number);
				count--;
				if (tempList.isEmpty())
					break;
			}
		}
		int[] answer = new int[answerList.size()];
		for (int an = 0; an < answerList.size(); an++) {
			answer[an] = answerList.get(an);
		}
		return answer;
	}

	public int[] solution1st(String[] genres, int[] plays) {
		int answer[] = {};
		HashMap<String, Integer> gNp = new HashMap<String, Integer>();
		ArrayList<Integer> ansArr = new ArrayList<Integer>();
		for (int gpc = 0; gpc < genres.length; gpc++) {
			gNp.put(genres[gpc], gNp.getOrDefault(genres[gpc], 0) + plays[gpc]);
		}
		while (gNp.size() != 0) { // ���� �迭�� ũ�⿡ �°� ����
			int large = -1;
			String target_genre = "";
			for (String sam : gNp.keySet()) { // keyset classic, pop...etc
				if (large <= gNp.get(sam)) {
					large = gNp.get(sam);
					target_genre = sam;
				} // �ִ��� ���� genre ����
			}
			gNp.remove(target_genre); // while���� �� ���� ������ genre�� �������� �ʾƾ� �ϹǷ� ����
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int index = 0; index < genres.length; index++) { // Ÿ�� �帣�� play index ���� ����
				if (target_genre.equals(genres[index])) {
					arr.add(index);
				}
			}
			Collections.sort(arr, new Comparator<Integer>() { // comparator ����
				public int compare(Integer a, Integer b) {
					if (plays[a] > plays[b]) { // ��������(play������ ����)
						return -1;
					} else if (plays[a] < plays[b]) {
						return 1;
					} else if (a > b) { // ���� ��쿡�� index ������������ ����
						return 1;
					} else
						return -1;
				}
			});
			ansArr.add(arr.get(0));
			if (arr.size() >= 2)
				ansArr.add(arr.get(1));
		}
		answer = new int[ansArr.size()];
		for (int c = 0; c < ansArr.size(); c++) {
			answer[c] = ansArr.get(c);
		}
		return answer;
	}
}

class album implements Comparable<album> {
	String genre;
	int number;
	int plays;

	public album(String genre, int number, int plays) {
		this.genre = genre;
		this.number = number;
		this.plays = plays;
	}

	@Override
	public int compareTo(album a2) {
		if (this.plays < a2.plays) {
			return 1;
		} else if (this.plays > a2.plays) {
			return -1;
		} else {
			return this.number - a2.number;
		}
	}
}
