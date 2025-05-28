package com.soi.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178871">달리기 경주</a>
 */
public class L178871 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        for (String c : callings) {
            int index = playerMap.get(c);
            String prevStr = players[index - 1];
            players[index - 1] = c;
            players[index] = prevStr;
            playerMap.put(c, index - 1);
            playerMap.put(prevStr, index);
        }
        return players;
    }

    public static void main(String[] args) {
        L178871 test = new L178871();
        String[] result = test.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        Arrays.stream(result).forEach(System.out::println);
    }

}
