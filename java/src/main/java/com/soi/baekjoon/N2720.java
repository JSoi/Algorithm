package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class N2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int intCost = Integer.parseInt(br.readLine());
            CoinCalculator cal = new CoinCalculator(intCost);
            bw.write(cal.getStatus() + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static class CoinCalculator {
        private final Map<Integer, Coin> coins = Coin.getCoinMap();
        private final List<Integer> coinCount = new ArrayList<>(4);
        private int cost; // * 100

        public CoinCalculator(int c) {
            this.cost = c;
            for (int i = 0; i < coins.size(); i++) {
                int count = cost / coins.get(i).cost;
                coinCount.add(count);
                cost -= count * coins.get(i).cost;
            }
        }

        public String getStatus() {
            return coinCount.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }
    }

    private enum Coin { // 순서 보장 필요 - idx starts from 0
        QUARTER(25, 0), DIME(10, 1), NICKEL(5, 2), PENNY(1, 3);
        private final int cost;
        private final int order;

        Coin(int cost, int order) {
            this.cost = cost;
            this.order = order;
        }

        public static Map<Integer, Coin> getCoinMap() {
            return Arrays.stream(Coin.values()).collect(Collectors.toMap(coin -> coin.order, coin -> coin));
        }
    }
}
