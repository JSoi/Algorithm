package com.soi.programmers;

import java.util.ArrayList;

public class POG_42839 {

    public static int[] numArr;
    public static ArrayList<Integer> array = new ArrayList<Integer>();

    public static void main(String[] args) {

        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        String[] numC = numbers.split("");
        numArr = new int[numC.length];
        int numi = 0;
        for (String a : numC) {
            numArr[numi++] = Integer.valueOf(a);
        }
        for (int n = 1; n <= numArr.length; n++) {
            boolean[] visit = new boolean[numArr.length];
            dfs("", 0, n, visit);
        }

        return array.size();
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int max = (int) Math.sqrt(number);
        for (int i = 2; i <= max; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(String str, int index, int count, boolean[] visit) {
        if (count == 0) {
            int val = Integer.valueOf(str);
            if (!array.contains(val) && isPrime(val)) {
                array.add(val);
                System.out.println(val);
            }
        } else {
            for (int i = 0; i < numArr.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(str + numArr[i], index, count - 1, visit);
                    visit[i] = false;
                }
            }
        }

    }
}
