package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int l = L; l <= 100; l++) {
            int startingNumber = N / l - (l - 1) / 2;
            if (startingNumber < 0) {
                System.out.println(-1);
                return;
            }
            int calculatedSum = (startingNumber * 2 + l - 1) * l / 2;
            if (calculatedSum == N) {
                for (int i = 0; i < l; i++) {
                    sb.append(startingNumber + i + " ");
                }
                System.out.println(sb.toString().trim());
                return;
            }
        }
        System.out.println(-1);
    }
}
