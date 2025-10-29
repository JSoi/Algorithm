package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(buf.readLine());
        StringTokenizer tok = new StringTokenizer(buf.readLine());
        long[] arr = new long[cnt];
        int[] before = new int[cnt];
        int[] dp = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Long.parseLong(tok.nextToken());
            before[i] = i;
            dp[i] = 1;
        }
        long max = 0;
        int maxIdx = 0;
        for (int i = 1; i < cnt; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    before[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }
        System.out.println(max);
        List<Long> result = new ArrayList<>();
        while (true) {
            result.add(arr[maxIdx]);
            if (before[maxIdx] == maxIdx) break;
            maxIdx = before[maxIdx];
        }
        Collections.reverse(result);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long num : result) {
            bw.append(String.valueOf(num)).append(" ");
        }
        bw.flush();
    }
}
