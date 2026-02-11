package com.soi.baekjoon;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int need = scan.nextInt();
        // 5x + 3y = need
        int result = Integer.MAX_VALUE;
        for (int xplus = 0; xplus <= (need / 5); xplus++) {
            int yplus = need - (xplus * 5);
            if (yplus % 3 == 0) {
                yplus = yplus / 3;
                if (result >= xplus + yplus) {
                    result = xplus + yplus;
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
        scan.close();
    }
}
