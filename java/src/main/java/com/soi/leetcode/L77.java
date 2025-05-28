package com.soi.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77 {
    public static void main(String[] args) {
        List<List<Integer>> answer = combine(4, 2);
        for (List<Integer> a : answer) {
            for (int ma : a) {
                System.out.print(ma + " / ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        // 선택한 경우
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        // 선택하지 않은 경우
        result.addAll(combine(n - 1, k));
        return result;
    }
}
