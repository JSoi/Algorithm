package com.soi.baekjoon;

import java.util.Scanner;
import java.util.stream.IntStream;

//DP Practice
public class BOJ_17202 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();

        int[] firstPhoneNumber = new int[8];
        int[] secondPhoneNumber = new int[8];
        for (int i = 0; i < 8; i++) {
            firstPhoneNumber[i] = Character.digit(aStr.charAt(i), 10);
            secondPhoneNumber[i] = Character.digit(bStr.charAt(i), 10);
        }
        solve(firstPhoneNumber, secondPhoneNumber);
    }

    private static void solve(int[] firstPhoneNumber, int[] secondPhoneNumber) {
        int[] array = IntStream.range(0, 8)
                .mapToObj(i -> new int[]{firstPhoneNumber[i], secondPhoneNumber[i]})
                .flatMapToInt(IntStream::of)
                .toArray();
        for (int i = 1; i < 15; i++) {
            for (int j = 15; j >= i; j--) {
                array[j] = (array[j - 1] + array[j]) % 10;
            }
        }
        System.out.println(array[14] + "" + array[15]);
    }

//    public static void main(String[] args) {
//
//        String aStr = "74759336";
//        String bStr = "36195974";
//        int[] A = new int[8];
//        int[] B = new int[8];
//        for (int i = 0; i < 8; i++) {
//            A[i] = Character.digit(aStr.charAt(i), 10);
//            B[i] = Character.digit(bStr.charAt(i), 10);
//        }
//        solve(A, B);
//    }
}
