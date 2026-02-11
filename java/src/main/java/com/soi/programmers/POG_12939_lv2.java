package com.soi.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class POG_12939_lv2 {

    public static void main(String[] args) {

        System.out.println(solution("1 2 3 4"));
    }

    static String solution(String s) {
        String[] split = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String str : split) {
            arr.add(Integer.parseInt(str));
        }
        Collections.sort(arr);
        return arr.get(0) + " " + arr.get(arr.size() - 1);
    }
}
