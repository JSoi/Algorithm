package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(tok.nextToken());
        int w = Integer.parseInt(tok.nextToken());
        int[] block = new int[w];
        tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < block.length; i++) {
            block[i] = Integer.parseInt(tok.nextToken());
        }
        int rain = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0, right = 0;
            for (int l = 0; l < i; l++) {
                left = Math.max(left, block[l]);
            }
            for (int r = w - 1; r > i; r--) {
                right = Math.max(right, block[r]);
            }
            int min = Math.min(left, right);
            if (min > block[i]) {
                rain += min - block[i];
            }
        }
        System.out.println(rain);
    }

}
