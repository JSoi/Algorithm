package com.soi.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class N15658 {
    static int[] operatorArr; // + - * /
    static int[] numArr;
    static long min;
    static long max;

    public static void main(String[] args) {
        operatorArr = new int[4];
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        numArr = new int[n];
        StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
        for (int c = 0; c < n; c++) {
            numArr[c] = Integer.parseInt(st.nextToken());
        }
        for (int sc = 0; sc < 4; sc++) {
            operatorArr[sc] = scan.nextInt();
        }
        scan.close();
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        calculate(1, numArr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculate(int index, int result) {
        if (index >= numArr.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operatorArr[i] < 1) { //+ - * /
                continue;
            }
            int operand = numArr[index];
            int nextResult;
            switch (i) {
                case 0:
                    nextResult = result + operand;
                    break;
                case 1:
                    nextResult = result - operand;
                    break;
                case 2:
                    nextResult = result * operand;
                    break;
                case 3:
                    nextResult = result / operand;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + i);
            }
            operatorArr[i]--;
            calculate(index + 1, nextResult);
            operatorArr[i]++;
        }
    }
}
