package com.soi.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class POG_42746 {

    public static void main(String[] args) {


    }

    public String solution(int[] numbers) {
        String result = "";
        String[] array = new String[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }

        if (result.startsWith("0")) {
            result = "0";
        }

        return result;

    }
}
