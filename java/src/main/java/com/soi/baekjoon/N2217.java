package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count += 1;
            int minVal = arr[i];
            int weightToCarry = minVal * count;
            answer = Math.max(answer, weightToCarry);
        }
        System.out.println(answer);
    }


}
