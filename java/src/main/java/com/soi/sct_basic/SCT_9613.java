package com.soi.sct_basic;

import java.util.Scanner;

public class SCT_9613 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        long[] resultarr = new long[testcase];
        for (int i = 0; i < testcase; i++) {
            int smallCount = scan.nextInt();
            int[] lineArray = new int[smallCount];
            for (int j = 0; j < smallCount; j++) {
                lineArray[j] = scan.nextInt();
            }
            long lineHap = 0;
            for (int fc = 0; fc < smallCount - 1; fc++) {
                for (int nc = 1; nc < smallCount - fc; nc++) {
                    lineHap += giveGCD(lineArray[fc], lineArray[fc + nc]);
                }
            }
            resultarr[i] = lineHap;
        }
        scan.close();
        for (int arrprint = 0; arrprint < testcase; arrprint++) {
            System.out.println(resultarr[arrprint]);
        }
    }

    public static int giveGCD(int first_nn, int second_nn) {
        int a = Math.min(first_nn, second_nn);
        int b = Math.max(first_nn, second_nn);
        int GCD = gcd(a, b);
        return GCD;
    }


    public static int gcd(int a, int b) {
        return (b % a) == 0 ? a : gcd(b, a % b);
    }
}
