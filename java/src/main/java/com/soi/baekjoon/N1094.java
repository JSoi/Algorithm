package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1094 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] status = new int[7];
        status[6] = 1;
        int sum = 64;
        while (sum > n) {
            int currentSum = sum(status);
            int shortestIdx = shortestIdx(status);

            status[shortestIdx] -= 1;
            status[shortestIdx - 1] += 2;
            int nextSum = currentSum - (1 << shortestIdx - 1);
//            System.out.println(nextSum + " " + Arrays.toString(status));
            if (n <= nextSum) {
                sum = nextSum;
                status[shortestIdx - 1]--;
            }
        }
        System.out.println(Arrays.stream(status).sum());
    }

    private static int shortestIdx(int[] status) {
        for (int i = 0; i <= 6; i++) {
            if (status[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private static int sum(int[] status) {
        int sum = 0;
        for (int i = 0; i <= 6; i++) {
            sum += (1 << i) * status[i];
        }
        return sum;
    }
}
