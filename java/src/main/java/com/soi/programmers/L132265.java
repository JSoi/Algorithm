package com.soi.programmers;

import java.util.HashMap;
import java.util.Map;

public class L132265 {
    public static void main(String[] args) {
        int sol1 = new L132265().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        int sol2 = new L132265().solution(new int[]{1, 2, 3, 1, 4});
        System.out.println("sol1 = " + sol1);
        System.out.println("sol2 = " + sol2);
    }

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> myTopping = new HashMap<>();
        Map<Integer, Integer> brotherTopping = new HashMap<>();
        for (int t : topping) {
            myTopping.put(t, myTopping.getOrDefault(t, 0) + 1);
        }
        for (int targetTopping : topping) {
            int myToppingValue = myTopping.get(targetTopping);
            if (myToppingValue == 1) {
                myTopping.remove(targetTopping);
            } else {
                myTopping.put(targetTopping, myToppingValue - 1);
            }
            brotherTopping.put(targetTopping, myTopping.getOrDefault(targetTopping, 0) + 1);
            if (myTopping.keySet().size() == brotherTopping.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}
