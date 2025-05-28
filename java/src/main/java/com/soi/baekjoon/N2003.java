package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] countLine = br.readLine().split(" ");
        long totalSum = Long.parseLong(countLine[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            long localSum = 0;
            for (int j = i; j >= 0; j--) {
                localSum += arr[j];
                if (localSum >= totalSum) {
                    if (localSum == totalSum) {
                        answer++;
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
