package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N1083 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int caseCount = scan.nextInt();
        int[] inputArr = new int[caseCount];
        for (int i = 0; i < caseCount; i++) {
            inputArr[i] = scan.nextInt();
        }
        int swapCount = scan.nextInt();
        for (int i = 0; i < inputArr.length - 1; i++) {
            if (swapCount <= 0) {
                System.out.println(Arrays.stream(inputArr).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
                return;
            }
            int toSwap = -1;
            int compare = inputArr[i];
            for (int j = i + 1; j < Math.min(inputArr.length, i + swapCount + 1); j++) {
                if (compare < inputArr[j]) {
                    compare = inputArr[j];
                    toSwap = j;
                }
            }
            if (toSwap == -1) { // nothing to swap
                continue;
            }
            for (int s = toSwap; s > i && swapCount > 0; s--, swapCount--) {
                int temp = inputArr[s];
                inputArr[s] = inputArr[s - 1];
                inputArr[s - 1] = temp;
            }
        }
        System.out.println(Arrays.stream(inputArr).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
