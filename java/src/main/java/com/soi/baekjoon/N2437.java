package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        Set<Integer> possible = new HashSet<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> tempSet = new HashSet<>();
            for (int p : possible) {
                tempSet.add(p + arr[i]);
            }
            possible.add(arr[i]);
            possible.addAll(tempSet);
        }
//        System.out.println(possible);
        int answer = 1;
        while (true) {
            if (!possible.contains(answer)) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }
}
