package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensors = new int[n];
        ArrayList<Integer> between = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        for (int i = 1; i < n; i++) {
            between.add(sensors[i] - sensors[i - 1]);
        }
        between.sort(Collections.reverseOrder());
        while (k-- > 1 && !between.isEmpty()) {
            between.remove(0);
        }
        System.out.println(between.stream().mapToInt(Integer::valueOf).sum());
    }
}
