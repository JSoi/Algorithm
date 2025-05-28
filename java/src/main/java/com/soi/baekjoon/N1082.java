package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1082 {
    private static int[] rooms;
    private static String[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int roomCount = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int money = Integer.parseInt(reader.readLine());
        rooms = new int[roomCount];
        int roomIndex = 0;
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            rooms[roomIndex] = Integer.parseInt(tok);
            roomIndex++;
        }
        Set<Integer> moneySet = new HashSet<>();
        for (int i = roomCount - 1; i >= 0; i--) {
            if (moneySet.contains(rooms[i])) {
                rooms[i] = -1;
            } else {
                moneySet.add(rooms[i]);
            }
        }
        dp = new String[money + 1];
        travel(money); // n -> [1,50]
        String max = dp[money];
        for (int i = roomCount - 1; i >= 0; i--) {
            if (rooms[i] == -1 || money - rooms[i] < 0) {
                continue;
            }
            String temp = trimZero(i + dp[money - rooms[i]]);
            if (larger(temp, trimZero(max))) {
                max = temp;
            }
        }
        System.out.println(max);
        reader.close();
    }

    private static String travel(int leftMoney) {
        if (leftMoney < 0) {
            return "";
        }
        if (dp[leftMoney] != null) {
            return dp[leftMoney];
        }
        String result = "";
        for (int i = rooms.length - 1; i >= 0; i--) {
            if (rooms[i] != -1 && leftMoney >= rooms[i]) {
                String nextResult = travel(leftMoney - rooms[i]);
                result = larger(result, i + nextResult) ? result : i + nextResult;
            }
        }
        dp[leftMoney] = result;
        return result;
    }

    private static String trimZero(String s1) {
        String result = s1.replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    private static boolean larger(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length();
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            return s1.charAt(i) > s2.charAt(i);
        }
        return true;
    }
}
