package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1644 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] prime = createPrimeList(n);
        int answer = 0;
        int len = prime.length;
        if (len == 0) {
            System.out.println(0);
            return;
        }

        int start = 0, end = 0;
        int cumulativeSum = prime[0];
        while (start < len) {
            if (cumulativeSum == n) {
                answer++;
                cumulativeSum -= prime[start++];
            } else if (cumulativeSum < n) {
                end++;
                if (end < len) cumulativeSum += prime[end];
                else break;
            } else {
                cumulativeSum -= prime[start++];
            }
        }
        System.out.println(answer);
    }

    private static int[] createPrimeList(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primeList = new ArrayList<>();
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }
            primeList.add(i);
            for (int j = i * 2; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }
}
