package com.soi.programmers;

import java.util.*;

public class L92334 {
	public static void main(String[] args) {
		String[] list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		System.out.println(Arrays.toString(solution(list, report, 2)));
		;
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Set<String> reportSet = new HashSet<String>();
		HashMap<String, Integer> reportMap = new HashMap<String, Integer>();
		HashMap<String, Integer> ReportCountMap = new HashMap<String, Integer>();
		for (String re : report) { // �ߺ�����
			reportSet.add(re);
		}
		for (String r : reportSet) { // (�Ű������� , ī��Ʈ)�� �ʿ� ����
			String reportedPerson = r.split(" ")[1];
			reportMap.put(reportedPerson, reportMap.getOrDefault(reportedPerson, 0) + 1);
		}
		for (String id : id_list) {
			ReportCountMap.put(id, 0);
		}

		ArrayList<String> badpplList = new ArrayList<String>();
		for (String r : reportMap.keySet()) {
			if (reportMap.get(r) >= k) {
				badpplList.add(r);
			}
		}

		for (String s : reportSet) {
			if (badpplList.contains(s.split(" ")[1])) { // �Ű���� ����� �����ڶ��
				ReportCountMap.put(s.split(" ")[0], ReportCountMap.getOrDefault(s.split(" ")[0], 0) + 1);
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = ReportCountMap.get(id_list[i]);
		}
		return answer;
	}
}