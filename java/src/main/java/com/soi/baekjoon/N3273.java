package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int count = 0;
        int left = 0;
        int right = n - 1;
//        System.out.println(Arrays.toString(arr));
        while (left < right) {
            int s = arr[left] + arr[right];
            if (s == sum) {
                count++;
                left++;
            } else if (s < sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
