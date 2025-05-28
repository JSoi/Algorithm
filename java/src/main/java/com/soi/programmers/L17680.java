package com.soi.programmers;

import java.util.ArrayList;

public class L17680 {
	// ĳ��
	// Least Recently Used
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA" }));
	}

	static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<String>();
		if (cacheSize == 0)
			return cities.length * 5;
		for (int i = 0; i < cities.length; i++) {
			String str = cities[i].toLowerCase();
			if (!cache.contains(str)) {// �������� ���� ���
				if (cache.size() < cacheSize) {
					cache.add(str);
					answer += 5;
					continue;
				}
				cache.remove(0);
				cache.add(str);
				answer += 5;
			} else { // ���� �� ��쿡
				for (int k = 0; k < cache.size(); k++) {
					if (str.equals(cache.get(k))) {
						cache.remove(k);
						break;
					}
				}
				cache.add(str);
				answer += 1;
			}
			// System.out.println(cache.toString());
		}
		return answer;
	}
}
