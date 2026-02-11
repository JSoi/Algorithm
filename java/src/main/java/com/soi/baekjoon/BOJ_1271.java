package com.soi.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1271 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        scan.close();
        BigInteger n = new BigInteger((line.split(" ")[0]));
        BigInteger m = new BigInteger((line.split(" ")[1]));
        System.out.print(n.divide(m) + "\n");
        System.out.print(n.subtract(m.multiply(n.divide(m))));
    }

}
