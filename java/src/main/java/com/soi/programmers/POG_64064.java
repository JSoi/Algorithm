package com.soi.programmers;

import java.util.HashSet;
import java.util.Set;

public class POG_64064 {
    static boolean[] visited;
    static String[] userIdArr;
    static String[] bannedIdArr;
    static Set<Integer> bitSet;

    public static void main(String[] args) {
        int solution = new POG_64064().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
//        int solution = new POG_64064().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        System.out.println("solution = " + solution);
    }

    private static void pick(int count) {
        if (count == bannedIdArr.length) {
            bitSet.add(toBitmask());
            return;
        }
        for (int i = 0; i < userIdArr.length; i++) {
            if (visited[i] || !isBanned(userIdArr[i], bannedIdArr[count])) {
                continue;
            }
            visited[i] = true;
            pick(count + 1);
            visited[i] = false;
        }
    }

    private static int toBitmask() {
        int n = visited.length;
        int bitmask = 0;
        while (n > 0) {
            bitmask |= ((visited[visited.length - n] ? 1 : 0) << (n - 1));
            n--;
        }
        return bitmask;
    }

    private static boolean isBanned(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] userId, String[] bannedId) {
        visited = new boolean[userId.length];
        userIdArr = userId;
        bannedIdArr = bannedId;
        bitSet = new HashSet<>();
        pick(0);
//        for (Integer i : bitSet) {
//            System.out.println(Integer.toBinaryString(i));
//        }
        return bitSet.size();
    }
}
