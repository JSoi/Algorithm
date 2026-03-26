package com.soi.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2023 {
    private static int n;
    private static List<Integer> weirdPrimeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = new Scanner(System.in).nextInt();
        createWeirdNumbers(0, "");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int wn : weirdPrimeNumbers) {
            bw.write(wn + "\n");
        }
        bw.flush();
    }


    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int div = 2; div <= Math.sqrt(num); div++) {
            if (num % div == 0) {
                return false;
            }
        }
        return true;
    }

    private static void createWeirdNumbers(int idx, String result) {
        if (result.length() >= n) {
            weirdPrimeNumbers.add(Integer.valueOf(result));
            return;
        }
        for (int i = 1; i <= 9; i++) {
            int subRes = Integer.parseInt(result + i);
            if (!isPrime(subRes)) continue;
            createWeirdNumbers(idx + 1, result + i);
        }
    }
}
