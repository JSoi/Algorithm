package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        int[] input = new int[caseCount];
        for (int i = 0; i < caseCount; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        for (int i = caseCount - 1; i >= 2; i--) {
            int left = i - 1;
            int right = i - 2;

            while (right >= 0) {
                if (input[left] + input[right] > input[i]) {
                    System.out.println(input[i] + input[left] + input[right]);
                    return;
                }
                right--;
            }
        }

        System.out.println(-1);
    }
}
