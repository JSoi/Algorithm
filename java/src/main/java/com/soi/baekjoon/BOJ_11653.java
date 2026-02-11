package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11653 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a == 1)
            return;
        boolean[] prime = new boolean[a + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= a; i++) {
            for (int j = 2; i * j <= a; j++) {
                prime[i * j] = false;
            }
        }
        StringBuffer buf = new StringBuffer();
        while (a > 1) {
            for (int i = 2; i <= a; i++) {
                if (prime[i] && (a % i == 0)) {
                    a /= i;
                    buf.append(i + "\n");
                    break;
                }
            }
        }
        System.out.println(buf);
    }

//	static boolean isPrime(int input) {
//		for (int j = 2; j * j <= input; j++) {
//			if (input % j == 0) {
//				return false;
//			}
//		}
//		return true;
//	}

}
