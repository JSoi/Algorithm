package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {
    private static int n, m;
    private static int[] screenings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        screenings = new int[n];
        long maxScreenTime = 0;
        for (int i = 0; i < n; i++) {
            screenings[i] = Integer.parseInt(br.readLine());
            maxScreenTime = Math.max(maxScreenTime, screenings[i]);
        }
        long left = 0;
        long right = maxScreenTime * ((m / n) + 1);
        while (left < right) {
            long mid = (left + right) / 2;
            if (peopleCount(mid) < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);

    }

    private static long peopleCount(long time) {
        long total = 0;
        for (int s : screenings) {
            total += time / s;
        }
        return total;
    }
}
