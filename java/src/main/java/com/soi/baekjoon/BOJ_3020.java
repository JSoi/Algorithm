package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean isLow = true;
        int[] collision = new int[h];
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            int start = isLow ? 0 : h - len;
            int end = isLow ? len : h;
            collision[start]++;
            if (end < h) {
                collision[end]--;
            }
            isLow = !isLow;
        }
//        System.out.println(Arrays.toString(collision));
        int accCollision = 0;
        int minCollision = Integer.MAX_VALUE;
        int minCollisionCount = 0;
        for (int i = 0; i < h; i++) {
            accCollision += collision[i];
            if (accCollision < minCollision) {
                minCollision = accCollision;
                minCollisionCount = 1;
            } else if (accCollision == minCollision) {
                minCollisionCount++;
            }
        }
        System.out.println(minCollision + " " + minCollisionCount);

    }
}
