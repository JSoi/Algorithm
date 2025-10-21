package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(line[0]);
            meetings[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int count = 0;
        int lastEnd = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEnd) {
                count++;
                lastEnd = meeting[1];
            }
        }
        System.out.println(count);

    }
}
