package com.soi.programmers;

import java.util.HashMap;

public class POG_42888 {

    public static void main(String[] args) {

        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan"});
    }

    static String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<String, String>();
        int enterleave = record.length;
        for (int i = 0; i < record.length; i++) {
            String[] strsplit = record[i].split(" ");
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
        for (int i = 0; i < record.length; i++) {
            if ((record[i].split(" ")[0]).equals("Enter")) {
                answer[answerIndex++] = user.get(record[i].split(" ")[1]) + "님이 들어왔습니다.";
            } else if ((record[i].split(" ")[0]).equals("Leave")) {
                answer[answerIndex++] = user.get(record[i].split(" ")[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
