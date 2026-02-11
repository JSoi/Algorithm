package com.soi.programmers;

import java.util.Stack;

public class POG_12980 {

    public static void main(String[] args) {

        System.out.println(solution(5000));
        System.out.println(solution(5));
    }

    static int solution(int n) {
        int ans = 0;
        int now = 0;
        Stack<Integer> stk = new Stack<Integer>();
        int m = n;
        stk.push(n);
        while (m > 1) {
            m = m % 2 == 1 ? (m - 1) / 2 : m / 2;
            System.out.println(" m : " + m);
            stk.push(m);
        }
        while (!stk.isEmpty()) {
            int target = stk.pop();
            ans += (target - now * 2);
            now = target;
        }
        return ans;
    }
}
