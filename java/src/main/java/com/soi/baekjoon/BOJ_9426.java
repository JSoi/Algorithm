package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_9426 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] input = new int[250000];
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] output = new int[n - k + 1];
        int middle;

        if (k % 2 == 0) {
            middle = k / 2 - 1;
        } else {
            middle = (k + 1) / 2 - 1;
        }
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            input[i] = Integer.parseInt(line);
        }
        scan.close();
        long time1 = System.currentTimeMillis();
        for (int w = 0; w < k; w++) {
            arr.add(input[w]);
        }
        Collections.sort(arr);
        long time2 = System.currentTimeMillis();
        output[0] = arr.get(middle);
        long time3 = System.currentTimeMillis();
        for (int q = 1; q < n - k + 1; q++) {

            addArr(input[q + k - 1], arr);
            removeArr(input[q - 1], arr);
            output[q] = arr.get(middle);
        }
        long time4 = System.currentTimeMillis();
        long hap = 0;
        for (int print = 0; print < n - k + 1; print++) {
            hap += output[print];
        }
        System.out.println(hap);
        System.out.println("ó�� Array ���� : " + (time2 - time1) + "�ð� �ҿ�");
        System.out.println("�ι�° Array ���� : " + (time4 - time3) + "�ð� �ҿ�");
    }

    public static void addArr(int target, ArrayList<Integer> arr) {
        int start = 0; // 0
        int last = arr.size() - 1; // 0
        int mid = 0;
        while (start < last) { // 1 2 3 4 5 6 7 - 4
            mid = (start + last) / 2; // 3
            if (arr.get(mid) > target)
                last = mid - 1;
            else
                start = mid + 1;
        }
        if (arr.get(start) <= target) {
            arr.add(start + 1, target);
        } else {
            arr.add(start, target);
        }
    }

    public static void removeArr(int target, ArrayList<Integer> arr) {
        int start = 0;
        int last = arr.size();
        int mid = 0;
        while (start <= last) { // 1 2 3 4 5 6 7 - 4
            mid = (start + last) / 2; // 3
            if (target == arr.get(mid)) {
                break;
            } else {
                if (target < arr.get(mid)) {
                    last = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        arr.remove(mid);
    }
}