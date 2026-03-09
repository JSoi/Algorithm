package com.soi.baekjoon;

import java.io.*;
import java.math.BigInteger;

public class BOJ_9507 {
    private static final BigInteger[] fibo = new BigInteger[70];
    public static void main(String[] args) throws IOException {
        createFibonacci();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int t = Integer.parseInt(br.readLine());
            bw.append(fibo[t].toString()).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void createFibonacci() {
        fibo[0] = fibo[1] = BigInteger.ONE;
        fibo[2] = BigInteger.valueOf(2);
        fibo[3] = BigInteger.valueOf(4);
        for (int i = 4; i < 70; i++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]).add(fibo[i - 3]).add(fibo[i - 4]);
        }
    }
}
