package com.soi.programmers;

public class L82612 {
    public long solution(int price, int money, int count) {
        long requiredMoney = (long) count * (count + 1) / 2 * price;
        return requiredMoney <= money ? 0 : requiredMoney - money;
    }
}
