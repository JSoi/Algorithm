package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        long min = Long.MAX_VALUE;
        int l = 0;
        int r = 0;
        long[] arr = new long[n];
        TreeSet<long[]> treeSet = new TreeSet<>(Comparator.comparingLong(a -> a[0]));
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tok.nextToken());
            treeSet.add(new long[]{arr[i], i});
        }
        for (int i = 0; i < n; i++) {
            long num = arr[i];
            treeSet.remove(new long[]{arr[i], i});
            long[] ceil = treeSet.ceiling(new long[]{-num, 0});
            long[] floor = treeSet.floor(new long[]{-num, 0});
            if (ceil != null && min > Math.abs(ceil[0] + num)) {
                l = i;
                r = (int) ceil[1];
                min = Math.abs(ceil[0] + num);
            }
            if (floor != null && min > Math.abs(floor[0] + num)) {
                l = i;
                r = (int) floor[1];
                min = Math.abs(floor[0] + num);
            }
            treeSet.add(new long[]{arr[i], i});
        }
        System.out.println(arr[l] + " " + arr[r]);
    }
}
