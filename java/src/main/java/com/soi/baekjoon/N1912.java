package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        buf.readLine();
        int[] valueArr = Arrays.stream(buf.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] dp = new int[valueArr.length];
        dp[dp.length - 1] = valueArr[dp.length - 1];
        int maxValue = valueArr[dp.length - 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.max(valueArr[i], valueArr[i] + dp[i + 1]);
            maxValue = Math.max(dp[i], maxValue);
        }
        System.out.println(maxValue);
    }
}
