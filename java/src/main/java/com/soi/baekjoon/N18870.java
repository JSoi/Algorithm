package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            tree.add(num);
        }

        HashMap<Integer, Integer> sequenceMap = new HashMap<>();
        int seq = 0;
        for (Integer t : tree) {
            sequenceMap.put(t, seq++);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(sequenceMap.get(a)).append(" ");
        }
        System.out.println(sb);
    }
}

