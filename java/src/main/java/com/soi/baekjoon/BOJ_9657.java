package com.soi.baekjoon;

import java.util.Scanner;

/**
 * <a href = "https://www.acmicpc.net/problem/9657">돌 게임 3</a>
 */
public class BOJ_9657 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        // SK : 1,3,4,5,6,8,10,11,12,13,
        // CY : 2,7,9,14
        System.out.println(n % 7 == 0 || n % 7 == 2 ? "CY" : "SK");
    }
}
