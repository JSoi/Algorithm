package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N12970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] s = new char[n];
        Arrays.fill(s, 'B');

        int aCount = 0;
        for (int i = 0; i < n && k > 0; i++) {
            k += aCount;
            int pairCount = n - i - 1;
            if (pairCount <= k) {
                k -= pairCount;
                aCount++;
                s[i] = 'A';
            } else {
                int idx = n - k - 1;
                if (idx >= i && idx < n) {
                    s[idx] = 'A';
                    k = 0;
                }
            }
        }
        if (k != 0) {
            System.out.println(-1);
        } else {
            System.out.println(new String(s));
        }
    }

}
