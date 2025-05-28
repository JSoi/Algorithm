package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int kim = input[1];
        int lim = input[2];
        int round = 1;
        while (true) {
            int kimIdx = (kim + 1) / 2;
            int limIdx = (lim + 1) / 2;
            if (kimIdx == limIdx) {
                System.out.println(round);
                break;
            }
            kim = kimIdx;
            lim = limIdx;
            round++;
        }
    }
}
