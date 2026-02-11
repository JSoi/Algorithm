package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_2294 {
    public static final int MAX = Integer.MAX_VALUE;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int coinCount = Integer.parseInt(input[0]);
        int totalMoney = Integer.parseInt(input[1]);
        ArrayList<Integer> coinList = new ArrayList<>();
        long[] dp = new long[totalMoney + 1];
        for (int inputCount = 0; inputCount < coinCount; inputCount++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        Arrays.fill(dp, MAX);
        coinList = coinList.stream().filter(c -> c <= totalMoney).distinct()
                .sorted().collect(Collectors.toCollection(ArrayList::new));
        for (int coin : coinList) {
            dp[coin] = 1;
            for (int c = coin + 1; c <= totalMoney; c++) {
                if (dp[c - coin] == MAX) {
                    continue;
                }
                dp[c] = Math.min(dp[c], dp[c - coin] + 1);
            }
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[totalMoney] == MAX ? -1 : dp[totalMoney]);
    }
}
