package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int change = Integer.parseInt(br.readLine());
            sb.append(CoinCalculator.calculate(change)).append("\n");
        }
        System.out.print(sb);
    }

    private enum Coin {
        // 가치 내림차순
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

        private final int value;

        Coin(int value) {
            this.value = value;
        }
    }

    private static class CoinCalculator {
        private static final Coin[] COINS = Coin.values();

        public static String calculate(int amount) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < COINS.length; i++) {
                int count = amount / COINS[i].value;
                amount %= COINS[i].value;
                result.append(count);
                if (i < COINS.length - 1) result.append(" ");
            }
            return result.toString();
        }
    }
}
