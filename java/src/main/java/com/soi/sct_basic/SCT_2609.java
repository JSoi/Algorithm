package com.soi.sct_basic;


import java.util.Scanner;

public class SCT_2609 {
    public static void main(String[] args) {
        Scanner scan_nn = new Scanner(System.in);
        int first_nn = scan_nn.nextInt();
        int second_nn = scan_nn.nextInt();
        scan_nn.close();
        int a = Math.min(first_nn, second_nn);
        int b = Math.max(first_nn, second_nn);
        int GCD = gcd(a, b);
        int LCM = (a * b) / GCD;
        System.out.println(GCD);
        System.out.println(LCM);
    }

    public static int gcd(int a, int b) {
        return (b % a) == 0 ? a : gcd(b, a % b);
    }
}
