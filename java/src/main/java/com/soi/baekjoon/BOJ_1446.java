package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1446 {
    static int[] distanceArr;
    static int[][] shortcutArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int count = input[0]; // [1,12]
        int distance = input[1]; // [1, 10,000]
        distanceArr = new int[distance + 1];
        for (int i = 0; i <= distance; i++) {
            distanceArr[i] = i;
        }
        shortcutArr = new int[count][3];
        for (int i = 0; i < count; i++) {
            shortcutArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }
        Arrays.sort(shortcutArr, Comparator.comparingInt(s -> s[0]));
        useShortcuts(0); // init
        for (int i = 1; i < distanceArr.length; i++) {
            distanceArr[i] = Math.min(distanceArr[i], distanceArr[i - 1] + 1);
            useShortcuts(i);
        }
        System.out.println(distanceArr[distance]);
    }

    private static void useShortcuts(int idx) {
        for (int[] shorcut : shortcutArr) {
            int start = shorcut[0];
            int end = shorcut[1];
            int cost = shorcut[2];
            if (start == idx && end < distanceArr.length && distanceArr[start] + cost < distanceArr[end]) {
                distanceArr[end] = distanceArr[start] + cost;
            }
        }
    }
}
