package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2309 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] ppl = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            ppl[i] = scan.nextInt();
            total += ppl[i];
        }
        loop:
        for (int i = 0; i < 8; i++) {
            int hap = total;
            for (int j = i + 1; j < 9; j++) {
                if (hap - ppl[i] - ppl[j] == 100) {
                    ppl[i] = ppl[j] = -1;
                    break loop;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int k : ppl) {
            if (k != -1) {
                arr.add(k);
            }
        }
        Collections.sort(arr);
        for (int k : arr) {
            System.out.println(k);
        }
    }

}
