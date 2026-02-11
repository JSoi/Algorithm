package com.soi.programmers;

public class POG_82612 {
    public long solution(int price, int money, int count) {
        long requiredMoney = (long) count * (count + 1) / 2 * price;
        return requiredMoney <= money ? 0 : requiredMoney - money;
    }
}
