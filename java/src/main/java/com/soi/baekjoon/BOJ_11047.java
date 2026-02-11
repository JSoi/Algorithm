package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fLine = br.readLine();
        int cnt = Integer.parseInt(fLine.split(" ")[0]);
        int total = Integer.parseInt(fLine.split(" ")[1]);
        int[] money = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int moneyCnt = 0;
        for (int j = money.length - 1; j >= 0; j--) {
            while (money[j] <= total) {
                total -= money[j];
                moneyCnt++;
            }
        }
        System.out.println(moneyCnt);
    }
}
