package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2163 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.close();
        // top-bottom
        System.out.println(dp(n, m));

    }

    public static int dp(int n, int m) {
        if (n <= 1 || m <= 1)
            return 0;
        else {
            System.out.println(n + "/" + m);
            return dp(n, m / 2) + dp(n, m - (m / 2)) + dp(n / 2, m) + dp(n - (n / 2), m)
                    + 3;
        }
    }

}
