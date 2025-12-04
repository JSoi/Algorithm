package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        HashMap<Long, Integer> aMap = new HashMap<>();

        long[] a = new long[n];
        a[0] = Long.parseLong(tok.nextToken());
        for (int i = 1; i < n; i++) {
            long val = Long.parseLong(tok.nextToken());
            a[i] = val + a[i - 1];
        }
        for (int i = 0; i < n; i++) {
            aMap.put(a[i], aMap.getOrDefault(a[i], 0) + 1);
            for (int j = i - 1; j >= 0; j--) {
                long value = a[i] - a[j];
                aMap.put(value, aMap.getOrDefault(value, 0) + 1);
            }
        }
        HashMap<Long, Integer> bMap = new HashMap<>();
        int m = Integer.parseInt(br.readLine());
        long[] b = new long[m];
        tok = new StringTokenizer(br.readLine(), " ");
        b[0] = Integer.parseInt(tok.nextToken());
        for (int i = 1; i < m; i++) {
            long val = Long.parseLong(tok.nextToken());
            b[i] = val + b[i - 1];
        }

        for (int i = 0; i < m; i++) {
            bMap.put(b[i], bMap.getOrDefault(b[i], 0) + 1);
            for (int j = i - 1; j >= 0; j--) {
                long value = b[i] - b[j];
                bMap.put(value, bMap.getOrDefault(value, 0) + 1);
            }
        }

        long answer = 0;
        for (Map.Entry<Long, Integer> aEntry : aMap.entrySet()) {
            Long bVal = t - aEntry.getKey();
            answer += (long) aEntry.getValue() * bMap.getOrDefault(bVal, 0);
        }
        System.out.println(answer);
    }
}
