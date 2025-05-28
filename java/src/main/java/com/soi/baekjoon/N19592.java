package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N19592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < testCaseCount; c++) {
            int[] variables = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] speedArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int velocity = N19592.getVelocity(speedArr, variables[1], variables[2]);
            sb.append(velocity).append("\n");
        }
        System.out.print(sb);
    }

    private static int getVelocity(int[] speedArr, int railDistance, int boostVelocity) {
        double shortestTime = Double.MAX_VALUE;
        int mySpeed = speedArr[speedArr.length - 1];
        for (int i = 0; i < speedArr.length - 1; i++) {
            shortestTime = Math.min((double) railDistance / speedArr[i], shortestTime);
        }
        return findMin(boostVelocity, mySpeed, railDistance, shortestTime);
    }

    private static int findMin(int boostV, int v, int dist, double minTime) {
        int start = 0;
        int end = boostV;
        if ((double) dist / v < minTime) {
            return 0;
        }
        if ((double) (dist - boostV) / v >= minTime - 1) {
            return -1;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            double time = (double) (dist - mid) / v + 1;
            if (time < minTime) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
