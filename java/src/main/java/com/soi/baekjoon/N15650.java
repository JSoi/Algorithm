package com.soi.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class N15650 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer tok = new StringTokenizer(scan.nextLine(), " ");
        int total = Integer.parseInt(tok.nextToken());
        int count = Integer.parseInt(tok.nextToken());
        boolean[] visit = new boolean[total];
        combination(total, 0, 0, count, visit);
    }

    private static void combination(int total, int idx, int count, int totalCount, boolean[] visit) {
        if (idx > total) {
            return;
        }
        if (count == totalCount) {
            print(visit);
            return;
        }
        for (int i = idx; i < total; i++) {
            visit[i] = true;
            combination(total, i + 1, count + 1, totalCount, visit);
            visit[i] = false;
        }
    }

    static void print(boolean[] visit) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                builder.append(i + 1).append(" ");
            }
        }
        System.out.println(builder.toString().trim());
    }
}
