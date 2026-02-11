package com.soi.programmers;

import java.util.ArrayList;

public class POG_12981 {

    public static void main(String[] args) {

        int[] answer = solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int[] turn = new int[n];
        char startC = words[0].charAt(0);
        ArrayList<String> dup = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            turn[i % n]++;
            if (startC == words[i].charAt(0) && !dup.contains(words[i])) {
                startC = words[i].charAt(words[i].length() - 1);
                dup.add(words[i]);
            } else {
                answer[0] = (i % n) + 1;
                answer[1] = turn[i % n];
                break;
            }
        }
        return answer;
    }
}
