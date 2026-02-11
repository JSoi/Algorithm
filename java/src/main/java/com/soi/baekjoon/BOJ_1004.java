package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int[] startAndEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int smallCount = Integer.parseInt(br.readLine());
            ArrayList<int[]> circles = new ArrayList<>();
            while (smallCount-- > 0) {
                circles.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            int tcCount = passCount(new int[]{startAndEnd[0], startAndEnd[1]}, new int[]{startAndEnd[2], startAndEnd[3]}, circles);
            bw.append(String.valueOf(tcCount)).append("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int passCount(int[] start, int[] end, List<int[]> circles) {
        int count = 0;
        for (int[] circle : circles) {
            int startValue = (int) (Math.pow(start[0] - circle[0], 2) + Math.pow(start[1] - circle[1], 2));
            int endValue = (int) (Math.pow(end[0] - circle[0], 2) + Math.pow(end[1] - circle[1], 2));
            int circleValue = circle[2] * circle[2];
            if (startValue < circleValue ^ endValue < circleValue) {
                count++;
            }
        }
        return count;
    }
}
