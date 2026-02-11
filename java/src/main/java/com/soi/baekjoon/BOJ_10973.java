package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10973 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        if (!prevPermutation(arr)) {
            System.out.println(-1);
        } else {
            for (int e : arr) {
                System.out.print(e + " ");
            }
        }
    }

    private static boolean prevPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i == 0) return false;
        int j = n - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }
        swap(arr, i - 1, j);
        sortDesc(arr, i, n - 1);
        return true;
    }


    private static void sortDesc(int[] arr, int start, int end) {
        Arrays.sort(arr, start, end + 1);
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
