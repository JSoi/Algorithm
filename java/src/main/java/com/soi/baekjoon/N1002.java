package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class N1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < caseCount; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            bw.append(count(line[0], line[1], line[2], line[3], line[4], line[5]) + "\n");
        }
        bw.flush();
    }

    public static int count(int x1, int y1, int r1, int x2, int y2, int r2) {
        double between = Math.sqrt(Math.pow((double) x2 - x1, 2) + Math.pow((double) y2 - y1, 2));
        if (between == 0 && r1 == r2) {
            return -1;
        } else if (between == r1 + r2 || between == Math.abs(r1 - r2)) {
            return 1;
        } else if (between < r1 + r2 && between > Math.abs(r1 - r2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
