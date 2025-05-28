package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N6603 {
    static int[] currentArr;
    static boolean[] map;
    static StringBuffer sb;

    public static void main(String[] args) {
        sb = new StringBuffer();
        Scanner scan = new Scanner(System.in);
        String line;
        while (!((line = scan.nextLine()).equals("0"))) {
            int[] inputIntArr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).skip(1).toArray();
            map = new boolean[50];
            for (int i : inputIntArr) {
                map[i] = true;
            }
            currentArr = new int[6];
            travel(0, 0);
        sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void travel(int depth, int start) {
        if (depth == 6) {
            sb.append(Arrays.stream(currentArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            sb.append("\n");
            return;
        }
        for (int i = start; i < 50; i++) {
            if (map[i]) {
                map[i] = false;
                currentArr[depth] = i;
                travel(depth + 1, i);
                map[i] = true;
            }
        }
    }
}
