package com.soi.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class N12865 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int weight = scan.nextInt();
        int[] dp = new int[weight + 1];
        for (int i = 0; i < count; i++) {
            int wVal = scan.nextInt();
            int vVal = scan.nextInt();
            if (wVal > weight) {
                continue;
            }
            for (int w = weight; w >= wVal; w--) {
                dp[w] = Math.max(dp[w], dp[w - wVal] + vVal);
            }
        }
        scan.close();
        int answer = 0;
        for (int w = 0; w <= weight; w++) {
            answer = Math.max(answer, dp[w]);
        }
        System.out.println(answer);
    }
}
