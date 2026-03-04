package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            int number = Integer.parseInt(tok.nextToken());
            arr[i] = number;
        }

        int[] lis = new int[n];
        int[] lisIdx = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        int length = 0;
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(lis, length, arr[i]);
            lis[pos] = arr[i];
            lisIdx[pos] = i;

            if (pos > 0) {
                prev[i] = lisIdx[pos - 1];
            }
            if (pos == length) {
                length++;
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        int idx = lisIdx[length - 1];
        while (idx != -1) {
            result.addFirst(arr[idx]);
            idx = prev[idx];
        }
//        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(length);
    }

    static int lowerBound(int[] arr, int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
