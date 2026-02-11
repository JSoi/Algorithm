package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_9625 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.close();
        int[] aArr = new int[count + 1];
        int[] bArr = new int[count + 1];
        aArr[0] = 1;
        bArr[0] = 0;
        for (int i = 0; i < count; i++) {
            int aToB = aArr[i];
            aArr[i + 1] = bArr[i];
            bArr[i + 1] += bArr[i] + aToB;
        }
//		System.out.println(Arrays.toString(aArr));
//		System.out.println(Arrays.toString(bArr));
        System.out.println(aArr[count] + " " + bArr[count]);
    }

}
