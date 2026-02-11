package com.soi.sct_basic;

import java.util.ArrayList;
import java.util.Scanner;

public class SCT_1978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int caseCount = scan.nextInt();
        int checkCount = 0;
        ArrayList<Integer> MNArr = createList();
        for (int i = 0; i < caseCount; i++) {
            int target = scan.nextInt();
            if (MNArr.contains(target))
                checkCount++;
        }
        scan.close();

        System.out.println(checkCount);
    }

    public static ArrayList<Integer> createList() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        for (int i = 3; i <= 1000; i++) {
            if (mnCheck(i))
                arr.add(i);
        }
        return arr;
    }


    public static boolean mnCheck(int a) {
        for (int c = a - 1; c >= 2; c--) {
            if (a % c == 0) {
                return false;
            }
        }
        return true;
    }
}
