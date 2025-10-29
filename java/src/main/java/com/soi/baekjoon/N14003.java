package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class N14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] prev = new int[n];
        int[] lisIndex = new int[n];

        StringTokenizer tok = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        int length = 0;
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(lis, 0, length, arr[i]);
            if (idx < 0) idx = -(idx + 1); // 삽입 위치 결정
            lis[idx] = arr[i]; // 값 저장
            lisIndex[idx] = i; // index 저장
            prev[i] = idx > 0 ? lisIndex[idx - 1] : -1;
            if (idx == length) length++;
        }

        System.out.println(length);
        Stack<Integer> stack = new Stack<>();
        int k = lisIndex[length - 1];
        while (k != -1) {
            stack.push(arr[k]);
            k = prev[k];
        }
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
}
