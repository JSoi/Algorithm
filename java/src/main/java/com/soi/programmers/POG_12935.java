package com.soi.programmers;

import java.util.ArrayList;

public class POG_12935 {

    public static void main(String[] args) {

        for (int i : solution(new int[]{4, 3, 2, 1})) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1)
            return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
            }
            list.add(arr[i]);
        }
        int[] answer = new int[list.size() - 1];
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != min)
                answer[count++] = list.get(i);
        }
        return answer;
    }
}
