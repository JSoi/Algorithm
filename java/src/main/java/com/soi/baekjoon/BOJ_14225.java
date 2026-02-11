package com.soi.baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_14225 {
    static Set<Integer> sumSet;
    static int[] numArr;

    public static void main(String[] args) {
        sumSet = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        numArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        combination(0, 0);
        boolean[] candidates = new boolean[1000001];
        for (int i = 1; i < candidates.length; i++) {
            if (!sumSet.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void combination(int index, int sum) {
        if (index >= numArr.length) {
            return;
        }
        sumSet.add(numArr[index]);
        for (int i = index; i < numArr.length; i++) {
            sumSet.add(numArr[i]);
            sumSet.add(sum + numArr[i]);
            combination(i + 1, sum + numArr[i]);
        }
    }

}
