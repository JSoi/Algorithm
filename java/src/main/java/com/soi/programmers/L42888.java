package com.soi.programmers;

import java.util.HashMap;

public class L42888 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
		"Change uid4567 Ryan" });
	}

	static String[] solution(String[] record) {
		HashMap<String, String> user = new HashMap<String, String>();
		int enterleave = record.length;
		for (int i = 0; i < record.length; i++) {// ����� �ľ�
			String strsplit[] = record[i].split(" ");
			String command = strsplit[0];
			String userId = strsplit[1];
			if (command.equals("Leave")) {
				continue;
			} else {
				String userNickName = strsplit[2];
				if (command.equals("Change")) {
					enterleave--;
				}
				user.put(userId, userNickName);
			}

		}
		String[] answer = new String[enterleave];
		int answerIndex = 0;
		for (int i = 0; i < record.length; i++) {// �α� ���
			if ((record[i].split(" ")[0]).equals("Enter")) {
				answer[answerIndex++] = user.get(record[i].split(" ")[1]) + "���� ���Խ��ϴ�.";
			} else if ((record[i].split(" ")[0]).equals("Leave")) {
				answer[answerIndex++] = user.get(record[i].split(" ")[1]) + "���� �������ϴ�.";
			}
		}
		return answer;
	}
}
